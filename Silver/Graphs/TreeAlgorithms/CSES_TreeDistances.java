import java.io.*;
import java.util.*;

public class CSES_TreeDistances {
    static ArrayList<Integer> g[];
    static int n;
    static int[] depth;
    static void init(){
        depth = new int[n + 1];
        g = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; ++i){
            g[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.valueOf(in.readLine());
        init();
        for(int i = 0 ; i < n - 1; ++i){
            st = new StringTokenizer(in.readLine());
            int a, b;
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        depth[1] = 0;
        int diameterA = dfs(1, 0);
        // System.out.println("Diameter A: "+  diameterA);
        depth[diameterA] = 0;
        int diameterB = dfs(diameterA, 0);
        // System.out.println("Diameter B: "+  diameterB);
        // System.out.println(Arrays.toString(depth));
        int[]maxDistance = new int[n + 1];
        for(int i = 1 ; i <= n ; ++i ){
            maxDistance[i] = depth[i];
        }
        depth[diameterB] = 0;
        dfs(diameterB, 0);
        // System.out.println(Arrays.toString(depth));
        for(int i = 1 ; i <= n ; ++i ){
            maxDistance[i] = Math.max(depth[i], maxDistance[i]);
            out.write(maxDistance[i] +" ");
        }
        in.close();
        out.flush();
        out.close();
    }
    static int dfs(int node, int father){
        int mostDeep = node;
        int deep = 0;
        for(int e : g[node]){
            if(e!=father){
                depth[e] = depth[node] + 1;
                int preDeep = dfs(e, node);
                if(depth[preDeep] > deep){
                    deep = depth[preDeep];
                    mostDeep = preDeep;
                }
            }
        }
        return mostDeep;
    }
}
