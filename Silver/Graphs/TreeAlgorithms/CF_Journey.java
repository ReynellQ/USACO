import java.io.*;
import java.util.ArrayList;

public class CF_Journey {
    static double []p;
    static int [] nPaths;
    
    static ArrayList<Integer> g[];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n = Integer.valueOf(in.readLine());
        p  = new double[n + 1];
        g = new ArrayList[n + 1];
        for(int i = 1 ; i <= n ; ++i)
            g[i] = new ArrayList<>();
        for(int i = 0 ; i < n - 1 ; ++i){
            int a, b;
            data = in.readLine().split(" ");
            a = Integer.valueOf(data[0]);
            b = Integer.valueOf(data[1]);
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, 0);
        out.write(String.format("%.10f", p[1]));
        in.close();
        out.flush();
        out.close();
    }
    private static void dfs(int node, int prev) {
        double acum = 0.0;
        int sons = 0;
        for(int e : g[node]){
            if(e != prev){
                dfs(e, node);
                acum+=p[e];
                sons++;
            }
        }
        
        p[node] = sons != 0 ? acum/sons  + 1: 0;
    }
}
