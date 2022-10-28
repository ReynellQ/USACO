import java.io.*;
import java.util.*;

public class USACO_MooTube {
    static ArrayList<Edge> g[];
    static int N, Q;
    static void init(){
        g = new ArrayList[N + 1];
        for(int i = 0 ; i <= N ; ++i){
            g[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("mootube.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("mootube.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        Q = Integer.valueOf(st.nextToken());
        init();
        for(int i = 0 ; i < N - 1 ; ++i){
            st = new StringTokenizer(in.readLine());
            int p, q, r;
            p = Integer.valueOf(st.nextToken());
            q = Integer.valueOf(st.nextToken());
            r = Integer.valueOf(st.nextToken());
            g[p].add(new Edge(q, r));
            g[q].add(new Edge(p, r));
        }
        for(int i = 0 ; i < Q ; ++i){
            st = new StringTokenizer(in.readLine());
            int k, v;
            k = Integer.valueOf(st.nextToken());
            v = Integer.valueOf(st.nextToken());
            int res = dfs(v, 0, k);
            out.write(res+"\n");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static int dfs(int node, int father, int k) {
        int res = 0;
        for(Edge e : g[node]){
            if(e.a != father){
                if(e.w >=k){
                    ++res;
                    res+=dfs(e.a, node, k);
                }
            }
        }
        return res;
    }
    static class Edge{
        int a, w;

        public Edge(int a, int w) {
            this.a = a;
            this.w = w;
        }
    }
}
