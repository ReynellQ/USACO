import java.io.*;
import java.util.*;

public class CSES_TreeDiameter {
    static ArrayList<Integer> g[];
    static int n;
    static int[] toLeaf, maxDistance;
    static void init(){
        toLeaf = new int[n + 1];
        maxDistance = new int[n + 1];
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
        for(int i = 0 ; i < n - 1 ; ++i){
            int a, b;
            st = new StringTokenizer(in.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, 0);
        int res = 0;
        for(int i = 1 ; i <= n ; ++i){
            res = Math.max(res, maxDistance[i]);
        }
        out.write(res+"");
        in.close();
        out.flush();
        out.close();
    }

    private static void dfs(int node, int father) {
        for(int e : g[node]){
            if(e != father){
                dfs(e, node);
            }
        }
        toLeaf[node] = 0;
        int maxLeaf = 0;
        for(int e : g[node]){
            if(e != father){
                toLeaf[node] = Math.max(toLeaf[node], toLeaf[e] + 1);
                if(toLeaf[maxLeaf] < toLeaf[e]){
                    maxLeaf = e;
                }
            }
        }
        int secondMaxLeaf = 0;
        for(int e : g[node]){
            if(e != father){
                if(toLeaf[secondMaxLeaf] < toLeaf[e] && e != maxLeaf){
                    secondMaxLeaf = e;
                }
            }
        }
        maxDistance[node] = toLeaf[maxLeaf] + toLeaf[secondMaxLeaf] + 2;
    }
}
