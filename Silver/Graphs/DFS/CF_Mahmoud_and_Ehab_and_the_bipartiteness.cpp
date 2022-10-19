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
vector<bool> visited;
vector<ll> colors, neigh;
ll reds, blues;
ll comp;

vector<int>g[MAX_N];

void dfs(int node, int color){
    visited[node] = true;
    colors[node] = color;
    if(color == 1){
        ++reds;
    }else{
        ++blues;
    }
    // cout << "Nodo: " << node<<"\n";
    for(int x : g[node]){
        neigh[node]++;
        if(!visited[x])
            dfs(x, color == 1 ? 2 : 1);
    }
        
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n; cin >> n;
    visited.resize(n + 1);
    colors.resize(n + 1);
    neigh.resize(n + 1);
    for(int i = 1 ; i < n ; ++i){
        int a, b; cin >> a >> b;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    visited.assign(n + 1, false);
    reds = 0;
    blues = 0;
    dfs(1, 1);
    long long res = 0l;
    for(int i = 1 ; i <= n ; ++i){
        if(colors[i] == 1){
            // cout << "Vecinos: " << neigh[i]<<"\n";
            // cout << "Total de azules: " << blues<<"\n";
            res+= (long long )blues-neigh[i];
        }
    }
    cout << res;
    return 0;
}