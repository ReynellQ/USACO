import java.io.*;
import java.util.*;

public class CSES_FlightRoutesCheck {
    static boolean[] visited;
    static ArrayList<Integer>[] g, gR;
    static int[] components;
    static int comp;
    static Stack<Integer> s;

    static void dfs(int node, boolean first){
        visited[node] = true;
        if(first){
            for(int e : g[node]){
                if(!visited[e])
                    dfs(e, first);
            }
            s.add(node);
        }else{
            components[node] = comp;
            for(int e : gR[node]){
                if(!visited[e])
                    dfs(e, first);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String []data;
        int n, m;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        m = Integer.valueOf(data[1]);
        g = new ArrayList[n + 1];
        gR = new ArrayList[n + 1];
        components = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1 ; i <= n ; ++i){
            g[i]  = new ArrayList<>();
            gR[i] = new ArrayList<>();
        }
        for(int i= 0 ; i < m ; ++i){
            data = in.readLine().split(" ");
            int a, b;
            a = Integer.valueOf(data[0]);
            b = Integer.valueOf(data[1]);
            g[a].add(b);
            gR[b].add(a);
        }
        s = new Stack<>();
        for(int i = 1 ; i <= n ; ++i){
            if(!visited[i]){
                dfs(i, true);
            }
        }
        comp = 1;
        Arrays.fill(visited, false);
        int x = s.peek();
        boolean res = false;
        while(!s.isEmpty()){
            int node = s.pop();
            if(!visited[node]){
                if(node != x){
                    res = true;
                    out.write("NO\n" +node + " " + x);
                    break;
                }
                    
                dfs(node, false);
                ++comp;
            }
        }
        if(!res){
            out.write("YES");
        }
        out.flush();
    }
}
