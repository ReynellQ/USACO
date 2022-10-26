#include <bits/stdc++.h>
#define INF INT_MAX
#define MINF INT_MIN
#define ll long long
#define PB push_back 
#define PF push_front
#define P_F pop_front
#define P_B pop_back
#define F front
#define B back
#define f first
#define s second
#define MP make_pair
#define FOR(i, a, b) for(ll i = a; i < b; i++)
#define FORI(i, a, b) for(ll i = a; i >= b; i--)

using namespace std;

const int MAX_N = 1010, MAX_M = 1010;
char grid[MAX_N][MAX_M];
int floodfill[MAX_N][MAX_M];
int n, m;

void initFloodFill(){
    for(int i = 0 ; i < n ; ++i)
        for(int j = 0 ; j < m ; ++j)
            floodfill[i][j] = 0;
}

bool isValid(int i, int j){
    return (i >= 0 && i < n) && (j >= 0 && j < m);
}
void floodFill(int i, int j){
    int dirI[] = { -1, 0, 0, 1};
    int dirJ[] = { 0, -1, 1, 0};
    floodfill[i][j] = 1;
    stack<pair<int, int>> s;
    s.push({i, j});
    while(!s.empty()){
        pair<int, int> p = s.top();
        s.pop();
        for(int k = 0 ; k < 4 ; ++k){
            int nI = p.first + dirI[k];
            int nJ = p.second + dirJ[k];
            if(isValid(nI, nJ)){
                if(floodfill[nI][nJ] == 0 && grid[nI][nJ]!='#'){
                    floodfill[nI][nJ] = 1;
                    s.push({nI, nJ});
                }
            }
        }
    }
}


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin>>n >>m;
    // cout << "Leyendo"<<endl;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            cin>>grid[i][j];
        }
    }
    initFloodFill();
    int value = 0;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            if(floodfill[i][j] == 0 && grid[i][j]!='#'){
                // cout << i <<" " <<j<<"\n";
                ++value;
                floodFill(i, j);
            }
        }
    }
    cout << value;
    return 0;
}