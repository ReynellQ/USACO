import java.io.*;
import java.util.*;

public class USACO_MilkFactory {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("factory.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("factory.out"));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> g[] = new ArrayList[N + 1];
        for(int i = 1 ; i < N + 1; ++i){
            g[i] = new ArrayList<>();
        }
        String[]data;
        int max = 0;
        for(int i = 0 ; i < N -1 ; ++i){
            int A, B;
            data = in.readLine().split(" ");
            A = Integer.valueOf(data[0]);
            B = Integer.valueOf(data[1]);
            g[B].add(A);
        }
        boolean res = false;
        for(int i = 1 ; i < N+1 ; ++i){
            boolean[] visited = new boolean[N+1];
            if(dfs(g, i, visited)){
                out.write(i+"");
                res = true;
                break;
            }
        }
        if(!res)
            out.write("-1");    
        out.flush();
        
    }
    static boolean dfs(ArrayList<Integer>[] g, int index, boolean[]visited){
        visited[index] = true;
        for(int e : g[index]){
            if(!visited[e]){      
                dfs(g, e, visited);
            }
        }
        for(int i = 1 ; i < visited.length ; ++i)
            if(!visited[i])
                return false;
        return true;
    }
}
