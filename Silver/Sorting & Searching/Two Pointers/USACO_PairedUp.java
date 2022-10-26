import java.io.*;
import java.util.*;
public class USACO_PairedUp {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("pairup.out"));
        StringTokenizer st;
        
        int N = Integer.valueOf(in.readLine());
        Pair[] cows = new Pair[N];
        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(in.readLine());
            int b = Integer.valueOf(st.nextToken());
            int a = Integer.valueOf(st.nextToken());
            cows[i] = new Pair(a, b);
        }
        Arrays.sort(cows);
        // System.out.println(Arrays.toString(cows));
        int l = 0, r = N - 1;
        int res = 0;
        for( ; r > - 1 ; --r){
            while(l <= r && cows[r].b > 0){
                int minCows = Math.min(cows[r].b, cows[l].b);
                // System.out.println(minCows);
                cows[r].b-= minCows;
                cows[l].b-= minCows;
                // System.out.println(cows[l] + " " + cows[r]);
                res = Math.max(cows[r].a +  cows[l].a, res);
                if(cows[l].b == 0)
                    ++l;
                
            }

        }
        out.write(res+"");
        out.flush();
        out.close();
    }
    static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair o) {
            return a != o.a ? a - o.a : b - o.b;
        }
        @Override
        public String toString() {
            return "{" + a + ", " + b + "}";
        }
        
        
    }
}
