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

set<int> subsetsum( vector<int>&a, int n, int m, int begin){
    set<int> res;
    for(int mask = 1 ; mask < (1 << n) ; ++mask){
        int sum = 0;
        for(int j = 0 ; j < n ; ++j){
            if( mask & (1 << j)){
                sum=(sum + a[j + begin])%m;
            }
        }
        res.insert(sum);
    }
    return res;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, m; cin >> n >> m;
    vector<int> a(n);
    for(int i = 0 ; i < n ; ++i)
        cin >> a[i];
    int mid = n / 2;
        set<int> A = subsetsum(a, mid, m, 0);
        A.insert(0);
        if(n % 2 != 0){
            mid++;
        }
        set<int> B = subsetsum(a, mid, m, n/2);
        B.insert(0);
        set<int> C;
        int res = 0;
        for(auto x : A){
            int search = m - x - 1;
            auto it = B.upper_bound(search);
            it--;
            int y = *it;
            res = max(res, x + y);
        }
        cout << res;
    
    return 0;
}