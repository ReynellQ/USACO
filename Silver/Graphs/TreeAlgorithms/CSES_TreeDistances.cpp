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
int depth[MAX_N];

int dfs(int node, int father){
    int mostDeep = node;
    int deep = 0;
    for(int e : g[node]){
        if(e!=father){
            depth[e] = depth[node] + 1;
            int preDeep = dfs(e, node);
            if(depth[preDeep] > deep){
                deep = depth[preDeep];
                mostDeep = preDeep;
            }
        }
    }
    return mostDeep;
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
    depth[1] = 0;
    int diameterA = dfs(1, 0);
    depth[diameterA] = 0;
    int diameterB = dfs(diameterA, 0);
    vector<int> maxDistance(n + 1);
    for(int i = 1 ; i <= n ; ++i ){
        maxDistance[i] = depth[i];
    }
    depth[diameterB] = 0;
    dfs(diameterB, 0);
    for(int i = 1 ; i <= n ; ++i ){
        maxDistance[i] = max(depth[i], maxDistance[i]);
        cout << maxDistance[i] << " ";
    }
    return 0;
}