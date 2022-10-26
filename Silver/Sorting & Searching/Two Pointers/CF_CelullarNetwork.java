import java.io.*;
import java.util.*;

/*
 * https://codeforces.com/contest/702/problem/C
 */
public class CF_CelullarNetwork {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, m;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        int[] a = new int[n], b = new int[m];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] =  Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < m ; ++i)
            b[i] =  Integer.valueOf(st.nextToken());
        int res = 0;
        int i = 0, j = 0;
        while(i < n && j < m){
            while( j + 1< m && Math.abs(a[i] - b[j + 1])<= Math.abs(a[i] - b[j])){
                ++j;
            }
            // System.out.println(i +" " + j);
            res = Math.max(res, Math.abs(a[i] - b[j]));
            ++i;
        }
        out.write(res+"");;
        in.close();
        out.flush();
        out.close();
    }
}
