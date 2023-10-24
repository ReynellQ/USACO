#include <bits/stdc++.h>

#define ll long long

using namespace std;
const ll DIV = 500000004ll;
const ll MOD = 1000000007ll;

int main()
{
    ll N; cin >> N;
    ll res = 0ll;
    ll rest = 0;
    for(ll i = 1 ; i*i <= N ; ++i){
        ll k = N/i;
    
        k = k%MOD;
        rest= (rest + i)%MOD;
        res = (res + i*k)%MOD ;
        res = (res - i*(i-1) + MOD)%MOD ;
        res = (res + (((k*(k + 1))%MOD)*DIV)%MOD ) %MOD;
        res = (res - rest + MOD)%MOD;
        
        //rest = rest + i;
        //res = res + ( i*k - i*(i-1) + (k*(k+1))/2 - rest); 
    } 
    cout << res << "\n";
    return 0;
}