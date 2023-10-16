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

const int MAXN = 23;
const int MOD = 1e9 + 7;
int DP[MAXN][1 << MAXN];
int likes[MAXN][MAXN];
int n;
void init(){
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < (1 << n) ; ++j){
            DP[i][j] = -1;
        }
    }
    DP[n - 1][0] = 1;
}
int solve(int i, int mask){
    if(mask == 0){
        return DP[i][mask] = 1;;
    }
    if(DP[i][mask]!= -1){
        return DP[i][mask];
    }
    int res = 0;
    for(int j = 0 ; j < n ; ++j){
        if( likes[i][j] &&  (mask & (1 << j)) ){
            //cout << "Bits choosed: " << i << " " << j << "\n";
            int newMask = mask ^(1 << j);
            res= (res + solve(i + 1, newMask))%MOD;
        }
    }
    return DP[i][mask] = res;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    cin >> n;
    for(int i = 0 ; i < n ; ++i){
        for(int j = 0 ; j < n ; ++j){
            cin >> likes[i][j];
        }
    }
    init();
    cout << solve( 0, (1 << n )- 1);
    return 0;
}