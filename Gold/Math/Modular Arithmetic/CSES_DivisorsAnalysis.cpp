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
const ll MOD = 1000000007;

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

ll P(int n, int k){
    ll p = k;
    p = p*(k+1);
    p = p/2;
    return binpow(n, p);
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    ll n; cin >> n;
    ll A = 1ll, B = 1ll, C = 1ll, A1 = 1ll;
    ll sum = 0;
    while(n--){
        ll x, k; cin >> x >> k;
        A = (A*(k + 1))%MOD;
        B = (B*( binpow(x, k + 1) - 1))%MOD;
        B = (B*(inv(x - 1)))%MOD;
        C = (binpow(C, k + 1)*binpow(P(x, k), A1))%MOD;
        A1 = (A1*(k + 1))%(MOD - 1);
    }
    cout << A << " " << B << " " << C;
    return 0;
}