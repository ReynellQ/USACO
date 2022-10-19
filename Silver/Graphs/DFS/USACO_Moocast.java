import java.io.*;
import java.util.ArrayList;

public class USACO_Moocast {
    static int N;
    static ArrayList<Integer>[] g; 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("moocast.out"));
        String[]data;
        N = Integer.valueOf(in.readLine());
        g = new ArrayList[N];
        for(int i = 0 ; i < N ; ++i){
            g[i] = new ArrayList<>();
        }
        int[]x, y, p;
        x = new int[N];
        y = new int[N];
        p = new int[N];
        for(int i = 0 ; i < N ; ++i){
            data = in.readLine().split(" ");
            x[i] = Integer.valueOf(data[0]);
            y[i] = Integer.valueOf(data[1]);
            p[i] = Integer.valueOf(data[2]);
            p[i] = p[i]*p[i];
        }
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < N ; ++j){
                if(i == j)
                    continue;
                int ed = euclideanDistance(x[i], x[j], y[i], y[j]);
                if(ed <= p[i])
                    g[i].add(j);
            }
        }
        int res = 0;
        for(int i = 0 ; i < N ; ++i){
            res = Math.max(res, dfs(i, new boolean[N]));
        }
        out.write(res+"");
        out.flush();
        out.close();
    }

    static int dfs(int node, boolean[]visited){
        visited[node] = true;
        int value = 1;
        for(int e : g[node]){
            if(!visited[e]){
                value+= dfs(e, visited);
            }
        }
        return value;
    }

    static int euclideanDistance(int x1, int x2, int y1, int y2){
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
