import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class USACO_Moocast_Gold {
    static class Edge implements Comparable<Edge>{
        int a, b;
        long w;
        public Edge(int a, int b, long w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(USACO_Moocast_Gold.Edge o) {
            if(w < o.w) return -1;
            if(w > o.w) return 1;
            return 0;
        }
        @Override
        public String toString() {
            return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
        }
        
    }
    static ArrayList<Integer> g[];
    static int[]x , y;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("moocast.out"));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        g = new ArrayList[N + 1];
        x = new int[N + 1];
        y = new int[N + 1];
        for(int i = 1 ; i <= N ; ++i){
            data = in.readLine().split(" ");
            x[i] = Integer.valueOf(data[0]);
            y[i] = Integer.valueOf(data[1]);
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 1 ; i <= N ; ++i){
            for(int j = i + 1 ; j <= N ; ++j){
                edges.add(new Edge( i, j, euclideanDistance(x[i], x[j], y[i], y[j]) ));
            }
        }
        Collections.sort(edges);
        System.out.println(edges);
        out.write(bs(edges, N)+"");
        out.flush();
    }
    private static long bs(ArrayList<Edge> edges, int N) {
        int l = 0, r = edges.size() - 1, mid;
        while(l <= r){
            mid = (l + r)/2;
            // System.out.println("CREANDO GRAFO con " + mid + " aristas ");
            if(!isValid(edges, mid, N)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return edges.get(l).w;
    }
    private static boolean isValid(ArrayList<Edge> edges, int mid, int n) {
        for(int i = 0 ; i <= n ; ++i){
            g[i] = new ArrayList<>();
        }
        for(int i = 0 ; i <= mid ; ++i){
            g[edges.get(i).a].add(edges.get(i).b);
            g[edges.get(i).b].add(edges.get(i).a);
        }
        boolean[] visited = new boolean[n + 1];
        if(dfs(1, visited) != n){
            return false;
        }
        return true;
    }
    private static int dfs(int i, boolean[] visited) {
        // System.out.println(i);
        visited[i] = true;
        int val = 1;
        for(int e : g[i])
            if(!visited[e])
                val+=dfs(e, visited);
        return val;
    }
    private static long euclideanDistance(int x1, int x2, int y1, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
