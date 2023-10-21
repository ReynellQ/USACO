#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n; cin >> n;
    long long prod = 1ll;
    set<int> s;
    for(int i = 1 ; i < n ; ++i){
        if(__gcd(n, i) == 1){
            prod= (prod*i)%n;
            s.insert(i);
        }
    }
    if(prod != 1){
        s.erase(prod);
    }
    cout << s.size() << "\n";
    for(int e : s){
        cout << e << " ";
    }
    return 0;
}
