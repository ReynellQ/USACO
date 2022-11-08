import java.io.*;
import java.util.*;
/*
 * https://codeforces.com/contest/977/problem/F
 */
public class CF_ConsecutiveSequence {
    static int n;
    static int[] a;
    static HashMap<Integer, Integer> dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.valueOf(in.readLine());
        a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        int resValue = solve();
        Stack<Integer> build = new Stack<>();
        int len = get(resValue);
        out.write(len+"\n");
        for(int i = n - 1 ; i > -1 ; --i){
            if(a[i] == resValue){
                build.push(i + 1);
                resValue--;
            }
        }
        while(!build.isEmpty()){
            out.write(build.pop() +" ");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static int solve() {
        dp = new HashMap<>();
        int res = 0;
        int max = 0;
        for(int i = 0 ; i < n ; ++i){
            dp.put(a[i], Math.max(get(a[i]), get(a[i] - 1) + 1));
            if(get(a[i]) > max){
                max = get(a[i]);
                res = a[i];
            }
        }
        return res;
    }
    private static int get(int i) {
        return dp.getOrDefault(i, 0);
    }
}
