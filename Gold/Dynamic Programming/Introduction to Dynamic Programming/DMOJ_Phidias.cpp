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

int DP[601][601];

void init(int W, int H){
    for(int i = 0 ; i <= W ; ++i){
        for(int j = 0 ; j <= W ; ++j){
            DP[i][j] = -1;
        }
    }
}

int solve(int W, int H){
    if(DP[W][H] != -1){
        return DP[W][H];
    }
    int ans = W*H;
    for(int i = 1 ; i < W ; ++i){
        ans = min(ans, solve(i, H) + solve(W - i, H));
    }
    for(int J = 1 ; J < H ; ++J){
        ans = min(ans, solve(W, j) + solve(W, H -  j));
    }
    return ans;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int W, H; cin >> W >> H;
    int N; cin >> N;
    while(N--){
        vector<int> w(n), h(n);
        for(int i = 0 ; i < n ; ++i) cin >> w[i] >> h[i];
        init(W, H);
        for(int i = 0 ; i < n ; ++i){
            DP[w[i]][w[j]] = 0;
        }
        cout << solve(W, H);
    }
    return 0;
}