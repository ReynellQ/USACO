import java.io.*;
import java.util.*;

public class USACO_Teamwork {
    static int N, K;
    static int[]DP;
    static int[]s;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("teamwork.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("teamwork.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        DP = new int[N];
        s = new int[N];
        for(int i = 0 ; i < N ; ++i){
            s[i] = Integer.valueOf(in.readLine());
        }
        // for(int i = 0 ; i < N ; ++i)
        //     solve(i);
        out.write(solve(N - 1)+ "");
        // System.out.println(Arrays.toString(DP));
        in.close();
        out.flush();
        out.close();
    }
    private static int solve(int n) {
        if(n == -1)
            return 0;
        if(n < 0)
            return Integer.MIN_VALUE;
        if(DP[n] > 0)
            return DP[n];
        int ans = s[n];
        int max = 0;
        for(int i = 0 ; i < K ; ++i){
            if(n - i > - 1)
                max = Math.max(max, s[n - i]);
            ans = Math.max(ans, (i + 1)*max + solve(n - i - 1));
        }
        return DP[n] = ans;
    }
}
