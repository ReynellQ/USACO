import java.io.*;
import java.util.*;

public class USACO_TheGreatRevegetation {
    static ArrayList<Integer> g[], gn[];
    static boolean [] visited;
    static int[] color;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("revegetate.out"));
        String[]data;
        data = in.readLine().split(" ");
        N = Integer.valueOf(data[0]);
        M = Integer.valueOf(data[1]);
        g = new ArrayList[N + 1];
        gn = new ArrayList[N + 1];
        color = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0 ; i <= N ; ++i){
            g[i] = new ArrayList<>();
            gn[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; ++i){
            data = in.readLine().split(" ");
            char C = data[0].charAt(0);
            int a, b;
            a = Integer.valueOf(data[1]);
            b = Integer.valueOf(data[2]);
            if(C == 'S'){
                gn[a].add(b);
                gn[b].add(a);
            }else{
                g[a].add(b);
                g[b].add(a);
            }
        }
        int res = numberOfBipartite();
        if(res == 0){
            out.write("0");
        }else{
            out.write("1");
            for(int i = 0 ; i < res ; ++i)
                out.write("0");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static int numberOfBipartite() {
        int res = 0;
        for(int i = 1 ; i <= N ; ++i){
            if(!visited[i]){
                if(dfs(i, 0)){
                    ++res;
                }else{
                    return 0;
                }
            }
        }
        return res;
    }
    private static boolean dfs(int node, int c) {
        color[node] = c;
        visited[node] = true;
        for(int e : g[node]){
            if(!visited[e]){
                dfs(e, (c + 1) % 2);
            }
            if(color[node] == color[c])
                return false;
        }
        for(int e : gn[node]){
            if(!visited[e]){
                dfs(e, c % 2);
            }
            if(color[node] != color[c])
                return false;
        }
        return true;
    }
}
