import java.io.*;
import java.util.*;
/*
 * https://codeforces.com/contest/1582/problem/F1
 */
public class CF_KorneyKornevichAndXor {
    static int n;
    static int[] a;
    static final int MAX_A = (1 << 9);
    static int INF = Integer.MAX_VALUE - 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.valueOf(in.readLine());
        st = new StringTokenizer(in.readLine());
        a = new int[n];
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        int[] dp = new int[MAX_A];
        for(int i = 0 ; i < MAX_A ; ++i)
            dp[i] = INF;
        dp[0] = 0;
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < MAX_A ; ++j){
                int xor = a[i]^j;
                
                if(dp[j] < a[i]){
                    dp[xor] = Math.min(a[i], dp[xor]);
                }
                    
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int j = 0 ; j < MAX_A ; ++j){
            if(dp[j] != INF)
                res.add(j);
        }
        out.write(res.size()+"\n");
        for(int x : res){
            out.write(x+" ");
        }
        in.close();
        out.flush();
        out.close();
    }
}