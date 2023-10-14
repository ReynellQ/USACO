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
const ll MOD = 998244353ll;

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
    int Q; cin >> Q;
    queue<pair<ll, ll>> queue;
    ll A = 1ll;
    ll B = 0ll;
    while(Q--){
        int q; cin >> q;
        if(q == 0 ){
            ll a, b; cin >> a >> b;
            queue.push({a, b});
            //calculate add
            A= (A*a)%MOD;
            B = (B*a +b)%MOD;
        }else if(q == 1){
            pair<ll, ll> e = queue.front(); queue.pop();
            // calculate erase
            A = (A*inv(e.f))%MOD;
            B = ((B - A*e.s)%MOD + MOD) % MOD;
        }else{
            ll x; cin >> x;
            ll res = (A*x)%MOD;
            res = (res + B)%MOD;
            cout << res << "\n";
        }
    }
    return 0;
}