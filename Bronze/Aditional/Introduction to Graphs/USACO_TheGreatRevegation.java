import java.io.*;
import java.util.*;

public class USACO_TheGreatRevegation {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("factory.out"));
        int N, M;
        String[]data;
        data = in.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        ArrayList<Integer> g[] = new ArrayList[N + 1];
        for(int i = 1 ; i < N + 1; ++i){
            g[i] = new ArrayList<>();
        }
        
        int max = 0;
        for(int i = 0 ; i < M; ++i){
            int A, B;
            data = in.readLine().split(" ");
            A = Integer.valueOf(data[0]);
            B = Integer.valueOf(data[1]);
            g[B].add(A);
            g[A].add(B);
        }
        int[]colors = new int[N+1];
        for(int i = 1 ; i < N + 1 ; ++i){
            Collections.sort(g[i]);
            colors[i] = -1;
        }
        colors[1] = 1;
        for(int i = 2 ; i < N + 1 ; ++i){
            int maxColor= 0;
            for(int e : g[i]){
                if(e > i )
                    break;
                maxColor = Math.max(maxColor, colors[e]);
            }
            colors[i] = maxColor + 1;
        } 
        for(int i = 1 ; i < N + 1 ; ++i)
            out.write(colors[i]+"");

        out.flush();
        
    }

}
