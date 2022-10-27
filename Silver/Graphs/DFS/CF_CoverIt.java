import java.io.*;
import java.util.*;

public class CF_CoverIt {
    static ArrayList<Integer> g[];
    static int[] color;
    static boolean[] visited;
    static int red, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.valueOf(in.readLine());
        while(t--!=0){
            red = 0;
            blue = 0;
            int n, m;
            st = new StringTokenizer(in.readLine());
            n = Integer.valueOf(st.nextToken());
            m = Integer.valueOf(st.nextToken());
            int a, b;
            g = new ArrayList[n + 1];
            color = new int[n + 1];
            visited = new boolean[n + 1];
            for(int i = 1 ; i <= n ; ++i){
                g[i] = new ArrayList<>();
                color[i] = -1;
            }
                
            for(int i = 0 ; i < m ; ++i){
                st = new StringTokenizer(in.readLine());
                a = Integer.valueOf(st.nextToken());
                b = Integer.valueOf(st.nextToken());
                g[a].add(b);
                g[b].add(a);
            }
            color[1] = 0;
            dfs(1, color[1]);
            // System.out.println(Arrays.toString(color));
            out.write( (red < blue ? red : blue)+"\n");
            for(int i = 1 ; i <= n ; ++i){
                if(red < blue){
                    if(color[i] == 0)
                        out.write(i +" ");
                }else{
                    if(color[i] == 1)
                        out.write(i +" ");
                }
            }
            out.write("\n");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static void dfs(int node, int c) {
        visited[node] = true;
        if(color[node] == 0){
            red++;
        }else{
            blue++;
        }
        for(int e : g[node]){
            if(color[e] == -1){
                color[e] = (c + 1)%2;
            }
        }
        for(int e : g[node]){
            if(!visited[e]){
                dfs(e, color[e]);
            }
        }
    }
}
