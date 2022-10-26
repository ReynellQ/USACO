import java.io.*;
import java.util.*;

public class USACO_DiamondCollector {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("diamond.out"));
        StringTokenizer st;
        int N, K;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        int[] diamonds = new int[N];
        for(int i = 0 ; i < N ; ++i)
            diamonds[i] =  Integer.valueOf(in.readLine());
        Arrays.sort(diamonds);
        int[] left = new int[N], right = new int[N];
        left[0] = 1;
        right[N - 1] = 1;
        int l, r;
        l = 0;
        for( r = 1 ; r < N ; ++r){
            while(l <= r && diamonds[r] - diamonds[l] > K)
                ++l;
            // System.out.println("L: " + l + ", R: " + r + ", diff: " + (diamonds[r] - diamonds[l]));
            left[r] = Math.max(left[r - 1], r - l + 1);
        }
        r = N - 1;
        for( l = N - 2 ; l > -1 ; --l){
            while(l < r && diamonds[r] - diamonds[l] > K)
                --r;
            right[l] = Math.max(right[l + 1], r - l + 1);
        }
        
        // System.out.println(Arrays.toString(diamonds));
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int res = 0;
        for(int i = 0 ; i < N - 1 ; ++i){
            res = Math.max(res, left[i] + right[i + 1]);
        }
        out.write(res+"");;
        in.close();
        out.flush();
        out.close();
    }
    
}
