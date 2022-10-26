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
int dp[MAX_N];

void dfs(int node){
    int sons = g[node].size();
    for(int e : g[node]){
        dfs(e);
        dp[node]+=dp[e];
    }
    dp[node]+= sons;
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
        int x; cin >> x;
        g[x].push_back(i + 2);
    }
    dfs(1);
    for(int i = 1 ; i <= n ; ++i)
         cout << dp[i] << " ";
    return 0;
}