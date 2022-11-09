import java.io.*;
import java.util.*;
/*
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=496
 */
public class USACO_CowJog {
    static int N;
    static long T;
    static long[] v;
    public static int solve() {
        ArrayList<Long> dp = new ArrayList<Long>();
        for (long i : v) {
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
        BufferedReader in = new BufferedReader(new FileReader("cowjog.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("cowjog.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        T = Long.valueOf(st.nextToken());
        v = new long[N];
        for(int i = 0 ; i < N ; ++i){
            int a, b;
            st = new StringTokenizer(in.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            v[i] = a;
            v[i]+=  b*T;
            v[i] = v[i]*-1;
        }
        // System.out.println(Arrays.toString(v));
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
}
