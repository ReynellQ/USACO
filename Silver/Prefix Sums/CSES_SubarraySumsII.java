import java.io.*;
import java.util.HashMap;

public class CSES_SubarraySumsII {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));   
        String[]data; 
        int n, x;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        x = Integer.valueOf(data[1]);
        data = in.readLine().split(" ");
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0l, 1l);
        long res = 0l, sum = 0l;
        for(int i = 0 ; i < n ; ++i){
            int e = Integer.valueOf(data[i]);
            sum+= e;
            if(map.containsKey(sum - x)){
                res+= map.get(sum - x);
            }
            map.put(sum, map.getOrDefault(sum, 0l) + 1);
        }

        out.write(res+"");
        out.flush();
        out.close();
    }
}
