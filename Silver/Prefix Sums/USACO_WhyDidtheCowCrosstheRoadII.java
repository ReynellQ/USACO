import java.io.*;

public class USACO_WhyDidtheCowCrosstheRoadII {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("maxcross.out"));   
        String[] data; 
        data = in.readLine().split(" ");
        int N, K, B;
        N = Integer.valueOf(data[0]);
        K = Integer.valueOf(data[1]);
        B = Integer.valueOf(data[2]);
        int[]sum = new int[N];
        for(int i = 0 ; i < B ; ++i){
            int e = Integer.valueOf(in.readLine()) - 1;
            sum[e]++;
        }
        for(int i = 1 ; i < N ; ++i){
            sum[i]+=sum[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = K ; i < N ; ++i){
            min = Math.min(min, rangeSum(i - K + 1, i, sum));
        }
        out.write(min+"");
        out.flush();
        out.close();
    }
    static int rangeSum(int L, int R, int[]arr){
        L--;
        if(L < 0){
            return arr[R];
        }
        return arr[R]- arr[L];
    }
}
