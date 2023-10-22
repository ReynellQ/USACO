#include <bits/stdc++.h>

#define ll long long

using namespace std;
const int MAXN = 1e5;
vector<int> primes(){
    vector<int> primes;
    vector<bool> prime(MAXN + 1);
    for(ll i = 2; i <= MAXN ; ++i ){
        if(!prime[i]){
            primes.push_back(i);
            for(ll j = i*i ; j<= MAXN ; j+=i){
                prime[j] = true;
            }
        }
    } 
    return primes;
}
int main()
{
    vector<int> p = primes();
    int n, k; cin >> n >> k;
    vector<int> a(n);
    for(int i = 0 ; i < n ; ++i) cin >> a[i];
    vector<int> b(n);
    map<int, int> mp;
    ll res = 0ll;
    for(int i = 0 ; i < n ; ++i){
        ll e = 1ll;
        ll f = 1ll;
        for(int j = 0 ; j < p.size() && a[i] != 1; ++j){
            int count = 0;
            int ncount;
            while(a[i] % p[j] == 0){
                a[i]/=p[j];
                count++;
            }
            count = count % k;
            ncount = (k - count)%k;
            for(int i = 0 ; i < count ; ++i){
                e = e*p[j];
            }
            for(int i = 0 ; i < ncount ; ++i){
                f = min(1000000LL, f*p[j]);
            }
        }
        
        //cout << e << " " << f << "\n";
        res = res + mp[f];
        mp[e]++;
        b[i] = e;
    }
    cout << res << "\n";
    //for(int i = 0 ; i < n ; ++i) cout << b[i] << " ";
    return 0;
}
