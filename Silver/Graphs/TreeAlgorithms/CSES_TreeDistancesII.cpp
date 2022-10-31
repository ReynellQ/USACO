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

const int MAX_N = 200010;

int n;
vector<int> g[MAX_N];
long long distances[MAX_N], p[MAX_N], ways[MAX_N];    

void dfs(int node, int father){
    distances[node] = 0ll;
    ways[node] = 0ll;
    p[node] = father;
    for(int e : g[node]){
        if(e!=father){
            dfs(e, node);
            distances[node]+= distances[e] + ways[e];
            ways[node]+=ways[e];
        }
    }
    ways[node]++;
}
void dfs2(int node, int father){
    for(int e : g[node]){
        if(e!=father){
            distances[e] = distances[node] - ways[e] + (n - ways[e]);
            dfs2(e, node);
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
    initIO();
    cin>>n ;
    for(int i = 0 ; i < n - 1 ; ++i){
        int A, B; cin >> A >> B;
        g[A].push_back(B);
        g[B].push_back(A);
    }
    dfs(1, 0);
    dfs2(1, 0);
    for(int i = 1 ; i<= n ; ++i){
        cout << distances[i]<<" ";
    }
    
    return 0;
}