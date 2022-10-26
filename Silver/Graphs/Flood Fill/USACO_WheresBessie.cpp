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

const int MAX_N = 110;
char grid[MAX_N][MAX_N];
int floodfill[MAX_N][MAX_N];
int n, m;
vector<int> lights[MAX_N*MAX_N];

void initFloodFill(){
    for(int i = 0 ; i < n ; ++i)
        for(int j = 0 ; j < n ; ++j)
            floodfill[i][j] = 0;
}

bool isValid(int i, int j){
    return (i >= 0 && i < n) && (j >= 0 && j < n);
}
bool isPossible(int i, int j){
    int dirI[] = { -1, 0, 0, 1};
    int dirJ[] = { 0, -1, 1, 0};
    for(int k = 0 ; k < 4 ; ++k){
        int nI = i + dirI[k];
        int nJ = j + dirJ[k];
        if(isValid(nI, nJ) && floodfill[nI][nJ] == 1){
            return true;
        }
    }
    return false;
}
void floodFill(int bi, int bj, int i, int j, char obj){
    int res = 0;
    int dirI[] = { -1, 0, 0, 1};
    int dirJ[] = { 0, -1, 1, 0};
    floodfill[i][j] = 1;
    // cout << "Current node: " << pos << "\n";
    
    for(int k = 0 ; k < 4 ; ++k){
        int nI = i + dirI[k];
        int nJ = j + dirJ[k];
        if(isValid(nI, nJ)){
            if(floodfill[nI][nJ] == 0 && grid[nI][nJ] == 1){
                floodFill(bi, bj, nI, nJ, obj);
            }
        }
    }
}
int constructGrids(int bi, int bj){
    for(int i = bi + 1; i < n ; ++i){
        for(int j = bj + 1 ; j < n ; ++j){

        }
    }
}
void initIO(string name = ""){
    ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
    if (name.size()) {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}
int main(){
    initIO("where");
    cin>>n;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < n ; ++j){
            cin >> grid[i][j];
        }
    }
    int res = 0;
    for(int bi = 0 ; bi < n ; ++bi){
        for(int bj = 0 ; bj < n ; ++bj){
            res+= constructGrids(bi, bj);
        }
    }
    return 0;
}