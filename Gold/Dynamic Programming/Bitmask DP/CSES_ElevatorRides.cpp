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

const int MAXN = 20;
pair<int, int> DP[(1 << MAXN)];

void init(){
    for(int i = 0 ; i < ( 1 << MAXN) ; ++i){
        DP[i] = {-1, -1};
    }
    DP[0] = {1, 0};
}
pair<int, int> solve(int mask, int n, int x, vector<int>&w){
    if(DP[mask].f != -1){
        return DP[mask];
    }
    pair<int, int> res = {MAXN + 1, 0};
    for(int b = 0 ; b < n ; ++b){
        if(mask & (1 << b)){
            pair<int, int> value = solve( mask ^ (1 << b), n, x, w);
            if(value.s + w[b] <= x){
                value.s+= w[b];
            }else{
                value.s = w[b];
                value.f = value.f + 1;
            }
            res = min(res, value);
        }
    }
    return DP[mask] = res;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, x; cin >> n >> x;
    init();
    vector<int> w(n);
    for(int i = 0 ; i < n ; ++i) cin >> w[i];
    cout << solve((1 << n) - 1, n, x, w).f;
    /*
    for(int i = 0 ; i < ( 1 << n) ; ++i){
        bitset<4> val(i);
        cout<< "Mask: " << val << ": " << DP[i].f << " " << DP[i].s << "\n";
    }
    */
    
    return 0;
}