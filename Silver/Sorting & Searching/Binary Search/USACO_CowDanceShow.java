import java.io.*;
import java.util.*;

public class USACO_CowDanceShow {
    static int N, T;
    static int[]d;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowdance.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("cowdance.out"));
        String[]data;
        data = in.readLine().split(" ");
        N = Integer.valueOf(data[0]);
        T = Integer.valueOf(data[1]);
        d = new int[N];
        for(int i = 0 ; i < N ; ++i)
            d[i] = Integer.valueOf(in.readLine());
        out.write(bs(N)+"");
        in.close();
        out.flush();
        out.close();
    }
    public static int bs(int n){
        int l = 0, r = n, mid;
        while(l < r){
            mid = (l + r + 1)/2;
            if(notPossible(mid)){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;
            }
        }
        //L is the last value that F(L) = true, we need the next.
        return l + 1;
    }

    private static boolean notPossible(int k) {
        if(k == N)
            return false;
        if(k == 0) 
            return true;
        PriorityQueue<Integer> val = new PriorityQueue<>( (a, b) -> a-b);
        for(int i = 0 ; i < N ; ++i){
            if(val.size() < k){
                val.add(d[i]);
                // System.out.println("Puedo hacer al mismo tiempo: " + d[i]);
            }else{
                int x = val.poll();
                val.add(x + d[i]);
                // System.out.println("Debo borrar " + x + " y empezar " + d[i] + ", teniendo tiempo " + (x+d[i]));
            }
        }
        int max = 0;
        while(!val.isEmpty()){
            max = Math.max(max, val.poll());
        }
        return max > T;
    }
}
