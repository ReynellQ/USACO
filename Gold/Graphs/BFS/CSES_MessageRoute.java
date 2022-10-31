import java.io.*;
import java.util.*;

public class CSES_MessageRoute {
    static ArrayList<Integer> g[];
    static int[] p;
    static int n, m;
    static void init(){
        g = new ArrayList[n + 1];
        p = new int[n + 1];
        for(int i = 1 ; i <= n ; ++i){
            g[i] = new ArrayList<>();
            p[i] = -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        int a, b;
        init();
        for(int i = 0 ; i < m ; ++i){
            st = new StringTokenizer(in.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        in.close();
        bfs(1);
        int travel = n;
        Stack<Integer> s = new Stack<>();
        if(p[travel] == -1){
            out.write("IMPOSSIBLE");
        }else{
            while(travel != 0){
                s.add(travel);
                travel = p[travel];
            }
            out.write(s.size()+"\n");
            while(!s.isEmpty()){
                out.write(s.pop()+" ");
            }
        }
        
        
        out.flush();
        out.close();
    }
    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        p[node] = 0;
        while(!q.isEmpty()){
            node = q.poll();
            if(node == n)
                return;
            for(int e : g[node]){
                if(p[e] == -1){
                    p[e] = node;
                    q.add(e);
                }
            }
        }
    }
}
