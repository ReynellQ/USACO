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

const int MAXN = 200010;
int DP[MAXN];
vector<int> bfs(vector<vector<int>>&g){
    vector<int> dist(g.size(), -1);
    dist[0] = 0;
    queue<int> pq;
    pq.push(0);
    while (!pq.empty()) {
        int u = pq.front();
        pq.pop();
        for (int v : g[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                pq.push(v);
            }
        }
    }
    return dist;
}
int solve(int i, vector<int>&d, vector<vector<int>>&g, vector<bool>& visited){
    visited[i] = true;
    DP[i] = d[i];
    for(int j : g[i]){
        if(d[i] < d[j]){
            if(!visited[j]) solve(j, d, g, visited);
            DP[i] = min(DP[i], DP[j]);
        }else{
            DP[i] = min(DP[i], d[j]);
        }
    }
    return DP[i];
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int t; cin >> t;
    
    while(t--){
        int n, m; cin >> n >> m;
        vector<vector<int>> g(n);
        while(m--){
            int u, v; cin >> u >> v;
            g[u - 1].PB(v - 1);
        }
        vector<int> d = bfs(g);
        vector<bool>visited(n);
        for(int i = 0 ; i < n ; ++i){
            solve(i, d, g, visited);

            cout << DP[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}