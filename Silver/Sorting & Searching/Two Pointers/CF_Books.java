/*
 * https://codeforces.com/contest/279/problem/B
 */
import java.io.*;
import java.util.*;
public class CF_Books {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        int n, t;
        n = Integer.valueOf(st.nextToken());
        t = Integer.valueOf(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        int l = 0, r = 0;
        int sum = 0;
        int res = 0;
        for( r = 0 ; r < n ; ++r){
            sum+= a[r];
            while(l < r && sum > t){
                sum-= a[l];
                l++;
            }
            // System.out.println("L: " + l +", R:" + r);
            if(sum <= t)
                res = Math.max(res, r - l + 1);
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
