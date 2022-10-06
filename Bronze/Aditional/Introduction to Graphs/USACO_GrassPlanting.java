import java.io.*;
import java.util.*;

public class USACO_GrassPlanting{
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("planting.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("planting.out"));
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
            g[A].add(B);
            g[B].add(A);
            max = Math.max(max, g[A].size());
            max = Math.max(max, g[B].size());
        }
        out.write((max + 1)+"");
        out.flush();
        in.close();
        out.close();
        
    }
}