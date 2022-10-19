import java.io.*;
import java.util.*;

public class CF_TheMeetingPlaceCannotBeChanged {
    static int n;
    static int[] x;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.valueOf(in.readLine());
        st = new StringTokenizer(in.readLine());
        x = new int[n];
        for(int i = 0 ; i < n ; ++i)
            x[i] = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        v = new int[n];
        for(int i = 0 ; i < n ; ++i)
            v[i] = Integer.valueOf(st.nextToken());
        in.close();
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    private static double bs() {
        double l = 0, r = 1e9, mid, epsilon = 1e-7;
        while(r - l > epsilon){
            mid = l + (r - l) / 2.0;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid;    
            }
        }
        return l + epsilon;
    }
    private static boolean notPossible(double time) {
        // System.out.println("Time: " + time);
        double L = Double.MAX_VALUE *-1, R = Double.MAX_VALUE;
        for(int i = 0 ; i < n ; ++i){
            double left = x[i] - (time*v[i]);
            double right = x[i] + (time*v[i]);
            // System.out.println("Left: " + left);
            // System.out.println("Right: " + right);
            L = Math.max(L, left);
            R = Math.min(R, right);
        }
        return L > R;
    }
}
