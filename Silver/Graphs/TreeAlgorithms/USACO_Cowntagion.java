import java.io.*;
import java.util.*;

public class USACO_Cowntagion {
    
    static ArrayList<Integer> g[];
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n = Integer.valueOf(in.readLine());
        g = new ArrayList[n + 1];
        dp = new int[n + 1];
        for(int i = 1 ; i <= n ; ++i)
            g[i] = new ArrayList<>();
        g[1].add(0);
        for(int i = 0 ; i < n - 1 ; ++i){
            int a, b;
            data = in.readLine().split(" ");
            a = Integer.valueOf(data[0]);
            b = Integer.valueOf(data[1]);
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, 0);
        out.write(dp[1]+"");
        in.close();
        out.flush();
        out.close();
    }
    private static void dfs(int node, int prev) {
        int sons = g[node].size() - 1;
        int res = 0;
        int pow = 1;
        while(pow<=sons){
            ++res;
            pow*=2;
        }
        res+=sons;
        for(int e : g[node]){
            if(e != prev){
                dfs(e, node);
                res+=dp[e];
            }
        }
        dp[node] = res;
    }
}
