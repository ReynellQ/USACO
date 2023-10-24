#include <bits/stdc++.h>

#define ll long long

using namespace std;
const int MAXN = 1e6 + 10;

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

map<ll, int> primeDecomposition(ll num, vector<int>& p){
    map<ll, int> mp;
    for(int i = 0 ; i < p.size() && num > 1 ; ++i){
        while(num % p[i] == 0){
            mp[p[i]]++;
            num/=p[i];
        }
    }
    if(num != 1){
        mp[num]++;
    }
    return mp;
}
const ll DIV = 500000004ll;
const ll MOD = 1000000007ll;

int main()
{
    ll N; cin >> N;
    ll res = 1ll;
    ll rest = 0;
    for(int i = 1 ; i*i <= N ; ++i){
        int k = N/i;
        rest= (rest + i)%MOD;
        res= (res + i*(k-1))%MOD ;
        res = ( res + ((k*(k + 1))%MOD)*DIV ) %MOD;
        res = (res - rest + MOD)%MOD;
    } 
    cout << res << "\n";
    return 0;
}
