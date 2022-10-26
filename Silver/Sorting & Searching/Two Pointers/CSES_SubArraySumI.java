/*
 * https://cses.fi/problemset/task/1660
 */
import java.io.*;
import java.util.*;

public class CSES_SubArraySumI {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, x;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        x = Integer.valueOf(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] =  Integer.valueOf(st.nextToken());
        in.close();
        long sum = 0l;
        int l = 0, r = 0;
        long res = 0l;
        for( r = 0 ; r < n ; ++r){
            sum+= a[r];
            while(l < r && sum-a[l] >= x){
                sum = sum-a[l] ;
                ++l;
            }
            if(sum == x)
                ++res;
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
