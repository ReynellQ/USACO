import java.util.*;
import java.io.*;

public class USACO_FencePlanning {
    static int N;
    static ArrayList<Integer>[] g; 
    static int[]x, y;

    static boolean[] visited;
    static int minX, maxX, minY, maxY;
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new FileReader("fendeplan.in")));
        BufferedWriter out = new BufferedWriter(new PrintWriter("fenceplan.out"));
        String[]data;
        int N, M;
        N = in.nextInt();
        M = in.nextInt();
        x = new int[N + 1];
        g = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0 ; i <= N ; ++i){
            g[i] = new ArrayList<>();
        }
        x = new int[N];
        y = new int[N];

        for(int i = 1 ; i <= N ; ++i){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        for(int i = 0 ; i < M ; ++i){
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        int res = 0;
        int minPerimeter = Integer.MAX_VALUE;
        for(int i = 1 ; i < N +1 ; ++i){
            minX = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            maxY = Integer.MIN_VALUE;
            if(!visited[i]){
                dfs(i);
                minPerimeter = Math.min(minPerimeter, ((maxX - minX) + (maxY - minY))*2);
            }
        }
        out.write(minPerimeter+"");
        out.flush();
        out.close();
    }

    static void dfs(int node){
        visited[node] = true;
        minX = Math.min(minX, x[node]);
        maxX = Math.max(maxX, x[node]);
        minY = Math.min(minY, y[node]);
        maxY = Math.max(maxY, y[node]);
        for(int e : g[node])
            if(!visited[e])
                dfs(e);
    }

    static int euclideanDistance(int x1, int x2, int y1, int y2){
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
