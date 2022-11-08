import java.io.*;
import java.util.*;

public class CSES_TwoSetsII {
    static int n, x;
    static int[] t;
    static int DP[][];
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        x = Integer.valueOf(st.nextToken());
        t = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            t[i] = Integer.valueOf(st.nextToken());
        Arrays.sort(t);
        in.close();
        DP = new int[n][x + 1];
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < x + 1 ; ++j){
                DP[i][j] = -1;
            }
        }
        int ans = 0;
        for(int i = 0 ; i <x +1 ; ++i){
            ans = (ans+solve(n - 1, x))%MOD;
        }
        out.write(ans+"");
        out.flush();
        out.close();
    }
    private static int solve(int sn, int sx) {
        if(sn == -1)
            return sx == 0 ? 1 : 0;
        if(DP[sn][sx]!=-1)
            return DP[sn][sx];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = sn ; i > -1 ; --i){
            min = Math.min(min, t[i]);
            max = Math.max(max, t[i]);
            if( max - min > sx)
                break;
            ans = (ans + solve(i - 1, sx - (max - min)))%MOD;
        }
        return DP[sn][sx] = ans;
    }
}
