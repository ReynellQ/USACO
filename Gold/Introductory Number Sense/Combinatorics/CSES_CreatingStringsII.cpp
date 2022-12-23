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

const int MOD = 1000000007;
long long binpow(long long a, long long b) {
    a %= MOD;
    long long res = 1;
    while (b > 0) {
        if (b & 1)
            res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }
    return res;
}
ll inv(ll a, ll mod){
  ll n = mod - 2;
  ll ans = binpow(a, n);
  return ans;
}
vector<ll> inv_factorial(vector<ll> fac, ll N) {
    vector<ll> invf(N + 1);
	invf[N] = inv(fac[N], MOD);
	for (int i = N; i >= 1; i--) {
		invf[i - 1] = invf[i] * i % MOD;
	}
    return invf;
}

vector<ll> factorial(ll N) {
	vector<ll> fac(N + 1);
    fac[0] = 1;
	for (int i = 1; i <= N; i++) 
		fac[i] = fac[i - 1] * i % MOD;
	return fac;
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    string s; cin >> s;
    int n = s.size();
    vector<int> chars(26);
    for( int i = 0 ; i < n ; ++i)
        chars[s[i] - 'a']++;
    vector<ll> fac = factorial(n);
    vector<ll> invf = inv_factorial(fac, n);
    ll res = fac[n];
    for(int i = 0 ; i < 26 ; ++i){
        res = (res * invf[ chars[i] ] ) % MOD;
    }
    cout<<res; 
    return 0;
}