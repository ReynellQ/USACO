import java.io.*;
import java.util.*;

public class CSES_SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int n, x;
        int[]a;
        data = in.readLine().split(" ");
        n = Integer.parseInt(data[0]);
        x = Integer.parseInt(data[1]);
        a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(data[i]);
        boolean res = false;
        for(int i = 0 ; i < n && !res; ++i){
            if(!map.containsKey(x-a[i])){
                map.put(a[i], i);
            }else{
                res = true;
                out.write( (map.get( x-a[i]) + 1 ) + " " + (i + 1));
                break;
            }
        }
        if(!res){
            out.write("IMPOSSIBLE");
        }    
        out.flush();
    }
}
