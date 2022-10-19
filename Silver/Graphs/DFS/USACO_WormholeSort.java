import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class USACO_WormholeSort {
    static int N;
    static ArrayList<Integer>[] g; 
    static int[] p, comp;
    static int component;
    static boolean[] visited;

    static class Edge implements Comparable<Edge>{
        int a, b, w;
        public Edge(int a, int b, int w) {
            this.a = a; this.b = b; this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return w -  o.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("wormsort.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("wormsort.out"));
        String[]data;
        data = in.readLine().split(" ");
        int M;
        N = Integer.valueOf(data[0]);
        M = Integer.valueOf(data[1]);
        g = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        comp = new int[N + 1];
        data = in.readLine().split(" ");
        p = new int[N + 1];
        for(int i = 0 ; i < N ; ++i) p[i + 1] = Integer.valueOf(data[i]);
        
        Edge[] edges = new Edge[M];
        for(int i = 0 ; i < M ; ++i){
            data = in.readLine().split(" ");
            int a, b, w;
            a = Integer.valueOf(data[0]);
            b = Integer.valueOf(data[1]);
            w = Integer.valueOf(data[2]);
            edges[i] = new Edge(a, b, w);
        }
        Arrays.sort(edges);
        out.write(bs(edges)+"");
        out.flush();
        out.close();
    }

    private static int bs(Edge[] edges) {
        int l = 0, r = edges.length;
        while(l<=r){
            int mid = (l + r)/2;
            if(isValid(mid, edges)){
                l = mid + 1;
            }else{
                r = mid  - 1;
            }
        }
        if(l - 1 == edges.length)
            return -1;
        return edges[l - 1].w;
    }

    private static boolean isValid(int index, Edge[] edges) {
        for(int i = 1 ; i <= N ; ++i){
            g[i] = new ArrayList<>();
            visited[i] = false;
            comp[i] = 0;
        }
        for(int i = index ; i < edges.length ; ++i){
            g[edges[i].a].add(edges[i].b);
            g[edges[i].b].add(edges[i].a);
        }
        for(int i = 1 ; i <= N ; ++i){
            if(!visited[i]){
                ++component;
                dfs(i);
            }
        }
        for(int i = 1 ; i <= N ; ++i){
            if(comp[i] != comp[p[i]])
                return false;
        }
        return true;
    }

    static void dfs(int node){
        visited[node] = true;
        comp[node] = component;
        int value = 1;
        for(int e : g[node]){
            if(!visited[e]){
                dfs(e);
            }
        }
    }

}
