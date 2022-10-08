import java.io.*;

public class YS_StaticRangeSum {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));    
        String[]data;
        data = in.readLine().split(" ");
        int N, Q;
        N = Integer.valueOf(data[0]);
        Q = Integer.valueOf(data[1]);
        long []A = new long[N], sum = new long[N];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < N ; ++i){
            A[i] = Integer.valueOf(data[i]);
            if(i == 0) sum[i] = A[i];
            else sum[i] = sum[i - 1] + A[i];
        }
        for(int i = 0 ; i < Q ; ++i){
            data = in.readLine().split(" ");
            int L, R;
            L = Integer.valueOf(data[0]) - 1;
            R = Integer.valueOf(data[1]) - 1;
            out.write(rangeSum(sum, L, R) + "\n");
        }
        
        out.flush();
        out.close();
    }
    static long rangeSum(long[] sum, int L, int R){
        if(L < 0)
            return sum[R];
        return sum[R] - sum[L];
    }

}
