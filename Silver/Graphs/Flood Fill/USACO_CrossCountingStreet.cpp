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
int grid[MAX_N][MAX_M];
int floodfill[MAX_N][MAX_M];
int n, m;
vector<pair<int, int>> wp;

void initFloodFill(){
    for(int i = 0 ; i < n ; ++i)
        for(int j = 0 ; j < m ; ++j)
            floodfill[i][j] = 0;
}

bool isValid(int i, int j){
    return (i >= 0 && i < n) && (j >= 0 && j < m);
}
void floodFill(int i, int j, int d){
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
                if(floodfill[nI][nJ] == 0 && abs(grid[nI][nJ]- grid[p.first][p.second])<=d){
                    floodfill[nI][nJ] = 1;
                    s.push({nI, nJ});
                }
            }
        }
    }
}
bool notPossible(int d){
    initFloodFill();
    floodFill(wp[0].first, wp[0].second, d);
    for(pair<int, int> p : wp){
        if(!floodfill[p.first][p.second])
            return true;
    }
    return false;
}
int solve(){
    int l = 0, r = 1000000000, mid;
    while(l <= r){
        mid = (l + r)/2;
        if(notPossible(mid)){
            l = mid + 1;
        }else{
            r = mid - 1;
        }
    }
    return l;
}
void initIO(){
    ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
    freopen("ccski.in", "r", stdin);
	freopen("ccski.out", "w", stdout);
}
int main(){
    initIO();
    cin>>n >>m;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            cin>>grid[i][j];
        }
    }
    wp.clear();
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < m ; ++j){
            int x; cin >>x;
            if(x)
                wp.push_back({i, j});
        }
    }
    cout << solve();
    return 0;
}