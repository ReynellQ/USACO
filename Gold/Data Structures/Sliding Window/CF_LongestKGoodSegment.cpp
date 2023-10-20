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
    int n, k; cin >> n >> k;
    vector<int> a(n);
    for(int i = 0 ; i < n ; ++i){
        cin >> a[i];
    }
    int r = 0;
    map<int, int> count;
    int maxL = -1, maxR = -1, maxSize = 0;
    for(int l = 0 ; l < n ; ++l){
        while(r <= n && count.size() <= k){
            int size = r - l;
            if(size > maxSize){
                maxSize = size;
                maxL = l;
                maxR = r - 1;
            }
            if(r != n)
                count[a[r]]++;
            r++;
        }
        count[a[l]]--;
        if(count[a[l]] == 0){
            count.erase(a[l]);
        }
    }
    cout << (maxL + 1) << " " << (maxR + 1);
    return 0;
}