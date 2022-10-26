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

bool isPossibleToPaint(int r, int l, int ocurrences, int m) {
    return (r - l + 1) <= ocurrences + m;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, q; cin >> n;
    string s; cin >> s;
    cin >> q;
    while(q--){
        int m; cin >>m;
        char c; cin >>c;
        int res = 0;
        int ocurrences = 0;
        int l = 0, r;
        for( r = 0 ; r < n ; ++r){
            if(s[r] == c)
                ++ocurrences;
            while(l < r && !isPossibleToPaint(r, l, ocurrences, m)){
                if(s[l] == c)
                    --ocurrences;
                ++l;
            }
            res = max(res, r - l + 1);
        }
        cout << res <<"\n";
    }
    return 0;
}