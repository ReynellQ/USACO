/*
 * https://codeforces.com/contest/1201/problem/C
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_MaximumMedian {
    static int n, k;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            a[i] = Integer.valueOf(st.nextToken());
        }
        in.close();
        Arrays.sort(a);
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    public static int bs(){
        int l = a[n / 2], r = Integer.MAX_VALUE - 10, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(possibleMedian(mid)){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;
            }
        }
        return l;
    }
    private static boolean possibleMedian(int m) {
        long res = 0l;
        for(int i = n/2 ; i < n ; ++i){
            res+= Math.max(0, m - a[i]);
        }
        return res <= k;
    }
}
