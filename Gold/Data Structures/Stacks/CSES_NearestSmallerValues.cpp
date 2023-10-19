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

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n; cin >> n;
    stack<pair<int, int>> s;
    vector<int> x(n);
    for(int i = 0 ; i < n ; ++i) cin >> x[i];
    vector<int> res(n);
    res[0] = 0;
    s.push({x[0], 1});
    for(int i = 1 ; i < n ; ++i){
        int ans = 0;
        while(!s.empty()){
            pair<int, int> p = s.top();
            if(p.f < x[i]){
                ans = p.s;
                break;
            }
            s.pop();
        }
        res[i] = ans;
        s.push({x[i], i+1});
    }
    for(int i = 0 ; i < n ; ++i) cout << res[i] << " ";
    return 0;
}