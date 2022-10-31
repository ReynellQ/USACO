import java.io.*;
import java.util.*;

public class USACO_MilkVisits {
    static ArrayList<Integer> g[];
    static int N;
    static int[] comps;
    static int maxComp;
    static char[] s;
    static void init(){
        comps = new int[N + 1];
        g = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; ++i)
            g[i] = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("milkvisits.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("milkvisits.out"));
        StringTokenizer st;
        int M;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        s = in.readLine().toCharArray();
        init();
        for(int i = 0 ; i < N - 1 ; ++i){
            st = new StringTokenizer(in.readLine());
            int X, Y;
            X = Integer.valueOf(st.nextToken());
            Y = Integer.valueOf(st.nextToken());
            g[X].add(Y);
            g[Y].add(X);
        }
        maxComp = 1;
        dfs(1, 0, 1);
        System.out.println(Arrays.toString(comps));
        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(in.readLine());
            int A, B;
            char C;
            A = Integer.valueOf(st.nextToken());
            B = Integer.valueOf(st.nextToken());
            C = st.nextToken().charAt(0);
            if(comps[A]!=comps[B]){
                out.write("1");
            }else{
                out.write( s[A - 1] == C ? "1" : "0");
            }
        }
        in.close();
        out.flush();
        out.close();
    }
    static void dfs(int node, int father, int comp){
        comps[node] = comp;
        for(int e : g[node]){
            if(e != father){
                if(s[e - 1] != s[node - 1]){
                    ++maxComp;
                    dfs(e, node, maxComp);
                }else{
                    dfs(e, node, comp);
                }
            }
        }
    }
}
