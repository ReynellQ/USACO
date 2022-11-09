import java.io.*;
import java.util.*;

public class CSES_IncreasingSubsecuence {
    static int n;
    static int[] a;
    public static int solve() {
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for (int i : a) {
            int pos = Collections.binarySearch(dp, i);
            pos = pos < 0 ? Math.abs(pos + 1) : pos;
            if (pos == dp.size()) {
                dp.add(i);
            } else {
                dp.set(pos, i);
            }
        }
        return dp.size();
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
