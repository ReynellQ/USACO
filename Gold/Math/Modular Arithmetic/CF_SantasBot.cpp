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
const int MAXN = 1000010;
const ll MOD = 998244353;

ll binpow(ll a, ll b) {
    a %= MOD;
    ll res = 1;
    while (b > 0) {
        if (b & 1) res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }
    return res;
}

ll inv(ll a){
  ll n = MOD - 2;
  ll ans = binpow(a, n);
  return ans;
}


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n; cin >> n;
    
    vector<int> count(MAXN);
    vector<ll> invr(MAXN);
    int K =0;
    for(int i = 0 ; i < n ; ++i){
        int k; cin >> k;
        K+= k;
        for(int j = 0 ; j < k ; ++j){
            int a; cin >>a;
            count[a]++;
            invr[a] = (invr[a] + inv(k))%MOD;
        }
    }
    ll num = 0ll;
    for(int i = 0 ; i <= MAXN ; ++i){
        num = (num + (count[i]*invr[i]) ) % MOD;
    }
    ll dem = n;
    dem*= n;
    dem = inv(dem);
    ll res = (num*dem) % MOD;
    cout << res;
    return 0;
}