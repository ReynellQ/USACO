import java.io.*;
import java.util.*;

public class CSES_ArrayDivision {
    static int n, k;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        x = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            x[i] = Integer.valueOf(st.nextToken());
        }
        
        in.close();
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    public static int bs(){
        int l = -1, r = Integer.MAX_VALUE - 100, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(notPossible(mid)){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;    
            }
        }
        return l + 1;
    }
    private static boolean notPossible(int maxSize) {
        int groups = 1;
        int acum = x[0];
        for(int i = 1 ; i < n ; ++i){
            if(acum + x[i] <= maxSize){
                acum+= x[i];
            }else{
                acum = x[i];
                groups++;
            }
        }
        return groups > k;
    }
}
