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

string s;
bool isPal[5010][5010];
int DP[5000][5000];

void initPal(int n){
    for(int i = 0 ; i < n ; ++i){
        for(int j  = 0 ; j < n ; ++j){
            if(i >= j){
                isPal[i][j] = true;
            }
        }
    }
    for(int i = n - 1 ; i > -1 ; --i){
        for(int j = i + 1; j < n ; ++j){
            if(s[i] == s[j] && isPal[i + 1][j - 1]){
                isPal[i][j] = true;
            }
        }
    }
}
void init(int n){
    for(int i = 0 ; i < n ; ++i){
        DP[i][i] = 1;
    }
    for(int i = n - 1 ; i > -1 ; --i){
        for(int j = i + 1; j < n ; ++j){
            DP[i][j] = isPal[i][j] + DP[i + 1][j] + DP[i][ j - 1] - DP[i + 1][j - 1];
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    cin >> s;
    initPal(s.length());
    init(s.length());
    int q; cin >> q;
    while(q--){
        int i, j; cin >> i >> j;
        i--; j--;
        cout << DP[i][j] << "\n";
    }
    return 0;
}