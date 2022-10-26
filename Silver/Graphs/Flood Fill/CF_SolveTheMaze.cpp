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

char grid[50][50];
int floodfill[50][50];
int n, m;

void initFloodFill(){
    for(int i = 0 ; i < n ; ++i)
        for(int j = 0 ; j < m ; ++j)
            floodfill[i][j] = 0;
}
void markTravel(){
    for(int i = 0 ; i < n ; ++i)
        for(int j = 0 ; j < m ; ++j)
            if(floodfill[i][j] == 1)
                 floodfill[i][j] = 2;

}
bool floodFill(int i, int j){
    int dirI[] = { -1, 0, 0, 1};
    int dirJ[] = { 0, -1, 1, 0};
    floodfill[i][j] = 1;
    bool res = false;
    if(i == n - 1 && j == m - 1)
        return true;
    for(int k = 0 ; k < 4 ; ++k){
        int nI = i + dirI[k];
        int nJ = j + dirJ[k];
        if( (nI >= 0 && nI < n) && (nJ >= 0 && nJ < m)){
            char cell = grid[i + dirI[k]][j + dirJ[k]];
            if(floodfill[nI][nJ] == 0 && (cell == '.' || cell == 'G')){
                bool next = floodFill(nI, nJ);
                if(next)
                    return true;
            }
                
            if(floodfill[nI][nJ] == 2)
                return true;
        }
    }
    return res;

}
bool isPossible(){
    int dirI[] = { -1, 0, 0, 1};
    int dirJ[] = { 0, -1, 1, 0};
    int nI;
    int nJ;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            if(grid[i][j] == 'B'){
                for(int k = 0 ; k < 4 ; ++k){
                    nI = i + dirI[k];
                    nJ = j + dirJ[k];
                    if( (nI >= 0 && nI < n) && (nJ >= 0 && nJ < m)){
                        if(grid[nI][nJ] == 'G')
                            return false;
                        if(grid[nI][nJ] == 'B')
                            continue;
                        grid[nI][nJ] = '#';
                    }
                }
            }
        }
    }
    initFloodFill();
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            if(grid[i][j] == 'G'){
                bool search = floodFill(i, j);
                if(!search)
                    return false;
                markTravel();
            }
        }
    }
    return true;
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int t; cin >> t;
    while(t--){
        cin>>n >>m;
        // cout << "Leyendo"<<endl;
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                cin>>grid[i][j];
            }
        }
        // cout << "Entrando"<<endl;
        cout << (isPossible() ? "Yes" : "No" )<<"\n";
    }
    
    return 0;
}