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
const int MAX_N = 1010;
int res[MAX_N][2];
int n;
void add(map<int, int> &multiset, int x){
    multiset[x]++;
}
void erase(map<int, int> &multiset, int x){
    multiset[x]--;
    if(multiset[x] == 0)
        multiset.erase(x);
}
bool solve(map<int, int> &multiset, int level, int sum){
    if(level == n)
        return true;
    //cout << "Hallando maximo"<<endl;
    int maxValue = (multiset.rbegin())->first;
    int obj = sum - maxValue;
    //cout << "Buscando elemento"<<endl;
    if(multiset.lower_bound(obj)->first == obj){
        int value = multiset[obj];
        if(sum - maxValue == maxValue){
            if( value > 1){
                erase(multiset, obj);
                erase(multiset, obj);
                res[level][0] = maxValue;
                res[level][1] = maxValue;
                if(solve(multiset, level + 1, maxValue))
                    return true;
                add(multiset, maxValue);
                add(multiset, maxValue);
            }
            return false;
        }else{
            erase(multiset, maxValue);
            erase(multiset, obj);
            res[level][0] = obj;
            res[level][1] = maxValue;
            if(solve(multiset, level + 1, maxValue))
                return true;
            add(multiset, maxValue);
            add(multiset, obj);
        }
    }
    return false;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int t; cin >> t;
    map<int, int> multiset;
    while(t--){
        multiset.clear();
        cin >> n;
        vector<int> a(2*n);
        for(int i = 0 ; i < 2*n ; ++i){
            cin >> a[i];
            add(multiset, a[i]);
        }
        sort(a.begin(), a.end());
        bool ans = false;
        //cout << "Lee correctamente"<<endl;
        for(int i = 0 ; i <= 2*(n - 1) ; ++i){
            if(solve(multiset, 0, a[i] + a[2*n - 1])){
                cout << "YES\n" << a[i] + a[2*n - 1] << "\n";
                for(int j = 0 ; j < n ; ++j)
                    cout << res[j][0] << " " << res[j][1] << "\n";
                ans = true;
                break;
            }
        }
        if(!ans){
            cout << "NO\n";
        }

    }
    return 0;
}