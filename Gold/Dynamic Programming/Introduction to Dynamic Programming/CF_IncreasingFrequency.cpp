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

const int MAXN = 500001;
int rangeSum(int i, int j, vector<int>& p){
    if(j < 0) return 0;
    if(i == 0) return p[j];
    return p[j] - p[i - 1];
}

int maxSubarraySum(vector<int>&arr ){
    int res = 0;
    int sum = 0;
    for(int i = 0 ; i < arr.size() ; ++i){
        sum = max(0, sum + arr[i]);
        res = max(res, sum);
    }
    return res;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int n, c; cin >> n >> c;
    vector<int> a(n); 
    for(int i = 0 ; i < n ; ++i) cin >> a[i];
    vector<int> prefix(n);
    prefix[0] = a[0] == c;
    for(int i = 1 ; i < n ; ++i) prefix[i] = prefix[i - 1] +  (a[i] == c);
    int dp[n];
    map<int, int> prev;
    vector<vector<int>> b(MAXN);
    
    for(int i = 0 ; i < n ; ++i){
        int j;
        if(prev.find(a[i]) == prev.end()){
            j = -1;
        }else{
            j = prev[a[i]];
        }
        int cs = rangeSum(j + 1, i - 1, prefix);
        b[a[i]].PB(-cs);
        b[a[i]].PB(1);
        prev[a[i]] = i;
    }
    int res = 0;
    for(int i = 0 ; i < MAXN ; ++i){
        if(i == c) continue;
        res = max(res, maxSubarraySum(b[i]));
    }
    res+= prefix[n - 1];
    cout << res << "\n";
    return 0;
}