import java.io.*;
import java.util.Arrays;

public class USACO_Gold_AngryCows {
    static int[] left, right;
    static Integer[]x;
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("angry.out"));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        x = new Integer[N];
        for(int i = 0 ; i < N ; ++i)
            x[i] = Integer.valueOf(in.readLine()) * 2;
        Arrays.sort(x);
        left = new int[N];
        right = new int[N];
        left[0] = -2;
        int l = 0;
        for(int i = 1 ; i < N ; ++i){
            left[i] = Integer.MAX_VALUE - 10;
            while( l + 1 < i && x[i] - x[l + 1] > left[l + 1] + 2){
                ++l;
            }
            left[i] = Math.min(left[l + 1] + 2, x[i] - x[l]);
        }
            
        
        right[N - 1] = -2;
        int r = N - 1;
        for(int i = N - 2 ; i > - 1 ; --i){
            right[i] = Integer.MAX_VALUE - 10;
            while(r - 1 > i && right[r - 1] + 2 < x[r - 1] - x[i])
                --r;
            right[i] = Math.min(right[r - 1] + 2, x[r] - x[i]);
        }
        l = 0;
        r = N - 1;
        
        int minPower = Integer.MAX_VALUE;
        while(l<r){
            minPower = Math.min(minPower, Math.max((x[r] - x[l])/2, 2 + Math.max(left[l], right[r])));
            if(left[l + 1] < right[r- 1]){
                ++l;
            }else{
                --r;
            }
        }
        out.write( String.format("%.1f", (minPower/2.0) ) );
        in.close();
        out.flush();
        out.close();
    }
}
