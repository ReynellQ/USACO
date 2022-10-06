import java.io.*;
import java.util.*;

public class CF_JuryMarks {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int k, n;
        int[]a, b;
        data = in.readLine().split(" ");
        k = Integer.valueOf(data[0]);
        n = Integer.valueOf(data[1]);
        data = in.readLine().split(" ");
        a = new int[k];
        b = new int[n];
        
        for(int i = 0 ; i < k ; ++i)
            a[i] = Integer.valueOf(data[i]);
        
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            b[i] = Integer.valueOf(data[i]);
        
        int[] sum = new int[k];
        sum[0] = a[0];
        for(int i = 1 ; i < k ; ++i)
            sum[i] = sum[i-1] + a[i];
        Set<Integer> possible = new HashSet<>();
        for(int i = 0 ; i < k ; ++i)
            possible.add(b[0] - sum[i]);
        
        int res = 0;
        for(int p : possible){
            Set<Integer> points = new HashSet<>();
            for(int i = 0 ; i < k ; ++i)
                points.add(p + sum[i]);
            res+=isValid(points, b);
        }
        out.write(res+"");
        out.flush();
    }

    private static int isValid(Set<Integer> points, int[] b) {
        for(int i = 0 ; i < b.length ; ++i)
            if(!points.contains(b[i]))
                return 0;
        return 1;
    }
}
