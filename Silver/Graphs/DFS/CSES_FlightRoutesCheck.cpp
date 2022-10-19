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

vector<int>g[MAX_N], gR[MAX_N];

void dfs(int node, bool first){
    visited[node] = true;
    if(first){
        for(int e : g[node]){
            if(!visited[e])
                dfs(e, first);
        }
        s.push(node);
    }else{
        components[node] = comp;
        for(int e : gR[node]){
            if(!visited[e])
                dfs(e, first);
        }
    }
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
        gR[b].push_back(a);
    }
    visited.assign(n + 1, false);
        for(int i = 1 ; i <= n ; ++i){
            if(!visited[i]){
                dfs(i, true);
            }
        }
        comp = 1;
        visited.assign(n + 1, false);
        int x = s.top();    
        while(!s.empty()){
            int node = s.top();
            s.pop();
            if(!visited[node]){
                if(node != x){
                    cout <<"NO\n"<< node<<" "<< x;
                    return 0;
                }
                dfs(node, false);
                ++comp;
            }
        }
    cout <<"YES";
    return 0;
}