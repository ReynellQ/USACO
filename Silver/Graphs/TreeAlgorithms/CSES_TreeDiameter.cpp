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
int toLeaf[MAX_N], maxDistance[MAX_N];

void dfs(int node, int father) {
    for(int e : g[node]){
        if(e != father){
            dfs(e, node);
        }
    }
    toLeaf[node] = 0;
    int maxLeaf = 0;
    for(int e : g[node]){
        if(e != father){
            toLeaf[node] = max(toLeaf[node], toLeaf[e] + 1);
            if(toLeaf[maxLeaf] < toLeaf[e]){
                maxLeaf = e;
            }
        }
    }
    int secondMaxLeaf = 0;
    for(int e : g[node]){
        if(e != father){
            if(toLeaf[secondMaxLeaf] < toLeaf[e] && e != maxLeaf){
                secondMaxLeaf = e;
            }
        }
    }
    maxDistance[node] = toLeaf[maxLeaf] + toLeaf[secondMaxLeaf] + 2;
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
    toLeaf[0] = -1;
    maxDistance[0] = -1;
    dfs(1, 0);
    
    int res = 0;
    for(int i = 1 ; i <= n ; ++i){
        res = max(res, maxDistance[i]);
    }
    cout << res;
    return 0;
}