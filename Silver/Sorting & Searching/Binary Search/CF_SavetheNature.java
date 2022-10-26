import java.io.*;
import java.util.*;

public class CF_SavetheNature {
    static int n;
    static long[]p;
    static int[] sieve;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int q = Integer.valueOf(in.readLine());
        while(q-- != 0){
            n = Integer.valueOf(in.readLine());
            p = new long[n];
            st = new StringTokenizer(in.readLine());
            for(int i = 0 ; i < n ; ++i)
                p[i] = Integer.valueOf(st.nextToken());
            Arrays.sort(p);
            int[] percent = new int[n];
            int x, a;
            st = new StringTokenizer(in.readLine());
            x = Integer.valueOf(st.nextToken());
            a = Integer.valueOf(st.nextToken());
            for(int i = a ; i <= n ; i+=a){
                percent[i - 1]+=x;
            }
            int y, b;
            st = new StringTokenizer(in.readLine());
            y = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            for(int i = b ; i <= n ; i+=b){
                percent[i - 1]+=y;
            }
            k = Long.valueOf(in.readLine());
            Pair[] benefits = new Pair[n];
            for(int i = 0 ; i < n ; ++i)
                benefits[i] = new Pair(percent[i], i);
            Arrays.sort(benefits);
            out.write(bs(benefits)+"\n");
        }
        in.close();
        out.flush();
        out.close();
    }
    
    private static int bs(Pair[] benefits) {
        int l = 0, r = n, mid;
        while(l < r){
            mid = l + (r - l + 1)/2;
            if(notPossible(mid, benefits)){
                l = mid;
            }else{
                r = mid - 1;
            }
        } 
        return l + 1 > n ? -1 : l + 1;
    }


    private static boolean notPossible(int tickets, Pair[] benefits) {
        if(tickets == 0)
            return true;
        int j = 0;
        long sum = 0l;
        for(int i = n - 1 ; i > -1 ; --i){
            if(benefits[i].b < tickets){
                sum+= (p[n - j - 1]*benefits[i].a)/100;
                ++j;
            }
        }
        return sum < k;
    }


    static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair o) {
            return a!=o.a ? a - o.a : b - o.b;
        }
        
    }
}
