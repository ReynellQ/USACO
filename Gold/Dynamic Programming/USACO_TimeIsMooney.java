import java.io.*;
import java.util.*;

public class USACO_TimeIsMooney {
    static int N, M, C;
    static int[]m;
    static ArrayList<Integer> g[];
    static int[][]DP;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("time.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("time.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        m = new int[N + 1];
        st = new StringTokenizer(in.readLine());
        g = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; ++i){
            m[i] = Integer.valueOf(st.nextToken());
            g[i] = new ArrayList<>();
        }   
        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(in.readLine());
            int a, b;
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            g[a].add(b);
        }
        in.close();
        int best = 0;
        DP = new int[1001][N + 1];
        for( int e : g[1]){
            DP[1][e] = DP[0][1] +  m[e];
        }
        for(int t = 1 ; t < 1000 ; ++t){
            for(int n = 1 ; n <= N ; ++n){
                if(DP[t][n]!=0)
                    for( int e : g[n]){
                        DP[t + 1][e] = Math.max(DP[t + 1][e], DP[t][n] + m[e]);
                    }
            }
            best = Math.max(best, DP[t][1] - t*t*C);
        }
        out.write(best+"");

        out.flush();
        out.close();
    }
}
