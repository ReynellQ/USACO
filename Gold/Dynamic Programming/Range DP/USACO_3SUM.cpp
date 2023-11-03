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
ll DP[5010][5010];

const int MIN_A = -1000010;
const int MAX_A =  1000010;
void solve(int n, vector<int>&A){
    for(int i = 0 ; i < n ; ++i){
        DP[i][i] = 0ll;
    }
    for(int i = 0 ; i < n - 1; ++i){
        DP[i][i + 1] = 0ll;
    }
    vector<int>map(MAX_A - MIN_A + 1);
    for(int i = n - 2 ; i > -1 ; --i){
        map[A[i + 1] - MIN_A]++;
        for(int j = i + 2; j < n ; ++j){
            int e = A[i] + A[j];
            e = -1*e;
            DP[i][j] = DP[i][j - 1] + DP[i + 1][j] - DP[i + 1][j - 1];
            if(e >= MIN_A && e <= MAX_A)
                DP[i][j]+= map[e - MIN_A];
            map[A[j] - MIN_A]++;
        }
        for(int j = i + 1; j < n ; ++j){
            map[A[j] - MIN_A] = 0;
        }
    }
}
void initIO(string name = ""){
    ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
    if (name.size()) {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}
int main(){
    initIO("threesum");
    int N, Q; cin >> N >> Q;
    //N = 5000; Q = 1;
    vector<int> A(N);
    for(int i = 0 ; i < N ; ++i) cin >> A[i];
    solve(N, A);
    for(int i = 0 ; i < Q ; ++i){
        int a, b; cin >> a >> b;
        //a = 1; b = N;
        a--;b--;
        cout << DP[a][b] << "\n";
    }
    return 0;
}