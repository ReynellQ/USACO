import java.io.*;
import java.util.*;

public class DMOJ_Rank {
    static ArrayList<Integer> g[];
    static boolean[] visited;
    static boolean[] cycle;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        g = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        cycle = new boolean[N + 1];
        for(int i = 1 ; i <= N ;++i){
            g[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < K ;++i){
            st = new StringTokenizer(in.readLine());
            int a, b, s_a, s_b;
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            s_a = Integer.valueOf(st.nextToken());
            s_b = Integer.valueOf(st.nextToken());
            if(s_a > s_b){
                g[a].add(b);
            }else{
                g[b].add(a);
            }
        }
        // for(int i = 1 ; i <= N ; ++i){
        //     System.out.println(g[i]);
        // }
        for(int i = 1 ; i <= N ; ++i){
            if(!visited[i]){
                dfs(i, new LinkedList<>());
            }
        }
        int res = 0;
        for(int i = 1 ; i <= N ; ++i){
            if(cycle[i])
                ++res;
        }
        out.write(res+"");
        in.close();
        out.flush();
        out.close();
    }
    private static void dfs(int node, LinkedList<Integer> track) {
        visited[node] = true;
        track.add(node);
        // System.out.println(track);
        for(int e : g[node]){
            if(!visited[e]){
                dfs(e, track);
            }else{
                // System.out.println("Ciclo: " );
                for(int i = track.size() - 1 ; i > - 1 ; --i){
                    // System.out.println(track.get(i) );
                    cycle[track.get(i)] = true; 
                    if(track.get(i) == e)
                        break;
                }
                // System.out.println();
            }
        }
        visited[node] = false;
        track.removeLast();
    }
}
