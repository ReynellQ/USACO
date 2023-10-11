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

vector<pair< pair<ll, ll>, int>> calculate( vector<pair<int, int>>&a, int n, int begin){
    vector<pair< pair<ll, ll>, int>> res;
    for(int mask = 0 ; mask < (1 << n) ; ++mask){
        pair<ll, ll> p;
        int k = 0;
        for(int j = 0 ; j < n ; ++j){
            if( mask & (1 << j)){
                ++k;
                p.f += a[begin + j].f;
                p.s += a[begin + j].s;
            }
        }
        res.PB({p, k});
    }
    return res;
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
    initIO("");
    int N; cin >> N;
    int xg, yg; cin >> xg >> yg;
    vector<pair<int, int>> directions(N);
    for(int i = 0 ; i < N ; ++i){
        int x, y; cin >> x >> y;
        directions[i] = {x, y};
    }
    int mid = N/2;
    vector<pair<pair<ll, ll>, int>> A = calculate( directions, mid, 0);
    sort(A.begin(), A.end());
    if(N % 2 != 0){
        mid++;
    }
    vector<pair<pair<ll, ll>, int>> B = calculate( directions, mid, N/2);
    for(int i = 0 ; i < B.size() ; ++i){
        B[i].f.f = xg - B[i].f.f;
        B[i].f.s = yg - B[i].f.s;
    }
    sort(B.begin(), B.end());
    /*
    for(int i = 0 ; i < A.size() ; ++i){
        cout << "["<< A[i].f.f << ", " << A[i].f.s << "] = " << A[i].s;
        cout << "\n";
    }
    cout << "\n";
    for(int i = 0 ; i < B.size() ; ++i){
        cout << "["<< B[i].f.f << ", " << B[i].f.s << "] = " << B[i].s;
        cout << "\n";
    }
    */
    vector<ll> res(N + 1);
    vector<ll> acum(N + 1);
    int j = 0, k = 0;
    for(auto p : A){
        //cout << "P: "<<p.f.f << ", " << p.f.s << "\n";
        while (j < B.size() && B[j].f <= p.f) {
                acum[B[j].s]++;
                j++;
            }
            
            while (k < B.size() &&  B[k].f < p.f) {
                acum[B[k].s]--;
                k++;
            }
            
            for (int instructions = 0; instructions <= (N / 2) + 1; instructions++) {
                res[p.s + instructions] += acum[instructions];
            }
            //cout << j << " "<< k << "\n";
    }
    for(int i = 1 ; i <= N ; ++i) cout << res[i] << "\n";
    return 0;
}