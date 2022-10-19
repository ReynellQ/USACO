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
vector<int> components;
int comp;

vector<int>g[MAX_N];

void dfs(int node){
    visited[node] = true;
    components[node] = comp;
    for(int x : g[node])
        if(!visited[x])
            dfs(x);
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, m; cin >> n >> m;
    visited.resize(n + 1);
    components.resize(n + 1);
    for(int i = 0 ; i < m ; ++i){
        int a, b; cin >> a >> b;
        g[a].push_back(b);
        g[b].push_back(a);
    }
    visited.assign(n + 1, false);
    comp = 0;
    for(int i = 1 ; i <= n ; ++i){
        if(!visited[i]){
            ++comp;
            dfs(i);
        }
    }
    cout << comp - 1 <<"\n";
    int cn = 1;
    for(int i = 2 ; i <= n ; ++i)
        if(components[cn] < components[i]){
            cout << cn <<" "<<i <<"\n";
            cn = i;
        }
            
    return 0;
}