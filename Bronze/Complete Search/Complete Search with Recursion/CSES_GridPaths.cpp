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
bool grid[9][9];
int dirI[] = {1, -1, 0,  0};
int dirJ[] = {0,  0, 1, -1};


int bk(vector<int> &ins, int i, int j, int level) {
    if( (grid[i + 1][j] && grid[i - 1][j]) && (!grid[i][j + 1] && !grid[i][j - 1]) )
        return 0;
    if( (grid[i][j + 1] && grid[i][j - 1]) && (!grid[i + 1][j] && !grid[i - 1][j]) )
        return 0;
    if(i == 7 && j == 1)
        return level == ins.size() ? 1 : 0;
    if(level == ins.size())
        return 0;
    int count = 0;
    if(ins[level] < 4){
        int nI = i + dirI[ins[level]];
        int nJ = j + dirJ[ins[level]];
        if(!grid[nI][nJ]){
            grid[nI][nJ] = true;
            count+=bk(ins, nI, nJ, level+1);
            grid[nI][nJ] = false;
        }
    }else{
        for(int index = 0 ; index <4 ; ++index){
            int nI = i + dirI[index];
            int nJ = j + dirJ[index];
            if(!grid[nI][nJ]){
                grid[nI][nJ] = true;
                count+=bk(ins, nI, nJ, level+1);
                grid[nI][nJ] = false;
            }
        }
    }
    return count;
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    string s; cin >> s;
    grid[1][1] = true;
    for(int i = 0 ; i < 8 ;++i){
        grid[0][i] = true;
        grid[i][0] = true;
        grid[8][i] = true;
        grid[i][8] = true;
    }
    vector<int> ins;
    for(int i = 0 ; i < s.length() ; ++i){
        if(s[i] =='D')
            ins.push_back(0);
        else if(s[i] == 'U')
            ins.push_back(1);
        else if(s[i] == 'R')
            ins.push_back(2);
        else if(s[i] == 'L')
            ins.push_back(3);
        else
            ins.push_back(4);
    }
    cout << bk(ins, 1, 1, 0);
    return 0;
}