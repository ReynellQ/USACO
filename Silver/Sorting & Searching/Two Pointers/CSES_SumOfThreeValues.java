import java.io.*;
import java.util.*;

public class CSES_SumOfThreeValues {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, x;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        x = Integer.valueOf(st.nextToken());
        Pair[] a = new Pair[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] =  new Pair(Integer.valueOf(st.nextToken()), i + 1);
        Arrays.sort(a);
        int l = 0, r = 0;
        boolean res = false;
        for(int i = 0 ; i < n && !res; ++i){
            l = i + 1;
            int sum = x - a[i].a;
            for( r = n - 1 ; r > -1 ; --r){
                while(l + 1 < r && a[l + 1].a + a[r].a <= sum)
                    ++l;
                // System.out.println("L: " + l +", R: " + r);
                if(l < r && a[l].a + a[r].a == sum){
                    res = true;
                    out.write(a[i].b + " " + a[l].b + " " + a[r].b);
                    break;
                }
            }
        }
        
        if(!res)
            out.write("IMPOSSIBLE");
        in.close();
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
            return a != o.a  ? a - o.a : b - o.b;
        }
    }
}
