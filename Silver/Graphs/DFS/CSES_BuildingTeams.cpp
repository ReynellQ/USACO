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

const int MAX_N = 100010;
stack<int> s;
vector<bool> visited;
vector<int> teams;
int comp;

vector<int>g[MAX_N];

bool dfs(int node, int color){
    visited[node] = true;
    teams[node] = color;
    bool ans = true;
    for(int x : g[node]){
        if(color == teams[x])
            return false;
        if(!visited[x])
            ans = ans && dfs(x, color == 1 ? 2 : 1);
    }
    return ans;
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, m; cin >> n >> m;
    visited.resize(n + 1);
    teams.resize(n + 1);
    for(int i = 0 ; i < m ; ++i){
        int a, b; cin >> a >> b;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    visited.assign(n + 1, false);
    comp = 0;
    bool res = true;
    for(int i = 1 ; i <= n ; ++i){
        if(!visited[i]){
            ++comp;
            res = res && dfs(i, 1);
        }
    }
    if(res){
        for(int i = 1 ; i <= n ; ++i)
            cout << teams[i] << " ";
    }else{
        cout << "IMPOSSIBLE";
    }
            
    return 0;
}