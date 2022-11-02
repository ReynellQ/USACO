import java.io.*;
import java.util.*;
/*
 * https://codeforces.com/problemset/problem/1418/C
 */
public class CF_MortalKombatTower {
    static final int MAX_N = 200010;
    static final int INF = 1000000000;
    static int[][] DP = new int[2][MAX_N];
    static int n;
    static int[]a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.valueOf(in.readLine());
        while(t-->0){
            n = Integer.valueOf(in.readLine());
            init();
            st = new StringTokenizer(in.readLine());
            a = new int[n + 1];
            for(int i = 1 ; i <= n ; ++i)
                a[i] = Integer.valueOf(st.nextToken());
            
            solve(0, n);
            solve(1, n);
            out.write(Math.min(DP[0][n], DP[1][n])+"\n");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static int solve(int player, int i) {
        if( i <= 0)
            return player == 1 ? 0 : INF;
        if(DP[player][i] != INF)
            return DP[player][i];
        int ans = INF;
        if(player == 0){
            ans = Math.min(ans, solve( (player + 1) % 2, i - 1) + a[i]);
            ans = Math.min(ans, solve( (player + 1) % 2, i - 2) + a[i] + a[i - 1]);
        }else{
            ans = Math.min(ans, solve( (player + 1) % 2, i - 1) );
            ans = Math.min(ans, solve( (player + 1) % 2, i - 2) );
        }
        return DP[player][i] = ans;
    }
    private static void init() {
        for(int i = 0 ; i < 2 ; ++i){
            for(int j = 0 ; j <= n ; ++j){
                DP[i][j] = INF;
            }
        }
    }
}
