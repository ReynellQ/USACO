import java.io.*;
import java.util.*;
/*
 * https://codeforces.com/gym/102951/problem/C
 */

public class CF_LCSOnPermutations {
    static int n;
    static int[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.valueOf(in.readLine());
        int[]a = new int[n], b = new int[n];
        arr = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; ++i){
            b[i] = Integer.parseInt(st.nextToken());
            map.put(b[i], i + 1);
        }
        for(int i = 0 ; i < n ; ++i){
            arr[i] = map.get(a[i]);
        }
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    public static int solve() {
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for (int i : arr) {
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
}
