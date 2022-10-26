import java.io.*;
import java.util.StringTokenizer;

public class CSES_AppleDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.valueOf(in.readLine());
        st = new StringTokenizer(in.readLine());
        int[] a = new int[N];
        for(int i = 0 ; i < N ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        long res = Long.MAX_VALUE;
        for(int mask = 0 ; mask < (1 << N ) ; ++mask){
            long groupA = 0l, groupB = 0l;
            for(int i = 0 ; i < N ; ++i){
                if( ( mask & (1 << i) ) != 0){
                    groupA = groupA + a[i];
                }else{
                    groupB = groupB + a[i];
                }
            }
            res = Math.min(res, Math.abs(groupA - groupB));
        }
        out.write(res+"");
        in.close();
        out.flush();
        out.close();
    }
}
