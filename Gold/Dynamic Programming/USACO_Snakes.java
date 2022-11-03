import java.io.*;
import java.util.*;
/*
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=945
 */
public class USACO_Snakes {
    static int N, K;
    static long[][]DP;
    static int[]a;
    static final long INF = Long.MAX_VALUE - Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("snakes.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("snakes.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        DP = new long[N][K + 1];
        for(int i = 0 ; i < N ; ++i)
            for(int j = 0 ; j <= K ; ++j)
                DP[i][j] = - 1;
        a = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < N ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        out.write(solve(N - 1, K)+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve(int n, int k) {
        int i = n;
        // System.out.println("DP("+n+", " + k+")");
        
        if(n == -1)
            return 0;
        if(k == -1 )
            return INF;
        if(DP[n][k] != -1)
            return DP[n][k];
        long ans = INF;
        long max = 0;
        long acum = 0;
        while(i >= 0){
            max = Math.max(max, a[i]);
            acum+=a[i];
            ans = Math.min(ans, max*(n - i + 1) - acum + solve(i - 1, k - 1));
            i--;
        }
        return DP[n][k] = ans;
    }
}
