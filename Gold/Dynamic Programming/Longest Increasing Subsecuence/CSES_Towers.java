import java.io.*;
import java.util.*;

/*
 * https://cses.fi/problemset/task/1073
 */
public class CSES_Towers {
    static int n;
    static int[] a;
    public static int solve() {
        ArrayList<Long> dp = new ArrayList<Long>();
        for (long i : a) {
            int pos = binarySearch(dp, i);
            if (pos >= dp.size()) {
                dp.add(i);
            } else {
                dp.set(pos, i);
            }
        }
        return dp.size();
    }
    static int binarySearch(ArrayList<Long> dp, long x){
        int l = 0, r = dp.size() - 1, mid;
        while(l <= r){
            mid = (l + r + 1)/2;
            if(dp.get(mid) <= x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.valueOf(in.readLine());
        a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
}
