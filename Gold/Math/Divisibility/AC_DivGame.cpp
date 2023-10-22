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

int main()
{
    vector<int> p = primes();
    ll N; cin >> N;
    map<ll, int> mp = primeDecomposition(N, p);
    int res = 0;
    for (auto it : mp){
        //i.first is the prime, i.second is the ocurrences
        ll val = 0;
        for(int i = 1 ; i <= MAXN ; ++i){
            val+= i;
            if(val <= it.second){
                res++;
            }
        }
    } 
    cout << res << "\n";
    return 0;
}
