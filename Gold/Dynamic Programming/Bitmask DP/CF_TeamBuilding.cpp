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

const int MAXN = 100010;
const int MAXP = 7;
int n, p, k;
ll DP[MAXN + 1][1 << MAXP];
vector<pair<ll, int>> a(MAXN);
vector<vector<int>> S(MAXN, vector<int>(MAXP));
void init(){
    for(int i = 0 ; i < MAXN ; ++i){
        for(int j = 0 ; j < (1 << MAXP) ; ++j){
            DP[i][j] = -1ll;
        }
    }
    DP[0][0] = 0ll;
}

ll solve(int i, int mask){
    if(DP[i][mask] != -1){
        return DP[i][mask];
    }
    int selected = __builtin_popcount(mask);
    
    ll res = MINF;
    if(i < selected){
        return DP[i][mask] = res;
    }
    //choose "i" to play in team, in any available space
    for(int b = 0 ; b < p ; ++b){
        if(mask & (1 << b)){
            //cout << "Value of player: " <<player[b] << "\n";
            res = max(res, solve(i - 1, mask ^ (1 << b)) + S[a[i - 1].s][b]);
        }
    }
    int c = i - selected - 1;
    if(c < k){//I can take this player to be public
        res = max(res, solve(i - 1, mask) + a[i - 1].f );
    }else{
        res = max(res, solve(i - 1, mask));
    }
    return DP[i][mask] = res;
}
void initIO(string name = ""){
    ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
    if (name.size()) {
		freopen((name + ".in").c_str(), "r", stdin);
	}
}
int main(){
    initIO("");
    init();
    cin >> n >> p >> k;
    for(int i = 0 ; i < n ; ++i){
        int e; cin >> e;
        a[i].f = e;
        a[i].s = i;
    }
    sort(a.begin(), a.begin() + n);
    reverse(a.begin(), a.begin() + n);
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < p ; ++j){
            cin >> S[i][j];
        }
    }
    cout << solve(n, (1 << p) - 1) << "\n";
    
    
    return 0;
}