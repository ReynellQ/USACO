import java.io.*;
import java.util.*;

public class CSES_FactoryMachines {
    static int n;
    static long t;
    static long[] k;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        t = Integer.valueOf(st.nextToken());
        k = new long[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            k[i] = Integer.valueOf(st.nextToken());
        in.close();
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    private static long bs() {
        long l = 0, r = Long.MAX_VALUE - 100, mid;
        while(l < r){
            mid = l + (r - l + 1)/2;
            // System.out.println("Probando " + mid);
            if(notPossible(mid)){
                l = mid;
                // System.out.println("No es posible con " + mid);
            }else{
                r = mid - 1;
                // System.out.println("Es posible con " + mid);
            }
        }
        return l + 1;
    }
    private static boolean notPossible(long time) {
        long products = 0;
        for(int i = 0 ; i < n ; ++i){
            products+=time/k[i];
            if(products >= t)
                return false;
        }
        return products < t;
    }
}
