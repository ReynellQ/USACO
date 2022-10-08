import java.io.*;
import java.util.*;

public class CF_GoodSubArrays {
    static int[]sumArray;
    static int t;
    static String[] s;
    public static void main(String[]args) throws IOException{
        try (BufferedReader f = new BufferedReader(new InputStreamReader(System.in))) {
            t = Integer.valueOf(f.readLine());
            s = new String[t];
            for(int i = 0 ; i < t ; ++i){
                f.readLine();
                s[i] = f.readLine();
            }
        }
        for(int i = 0 ; i < t ; ++i){
            System.out.println(goodSubArrays(s[i].toCharArray()));
            }
    }
 
    private static long goodSubArrays(char[] s) {
        long res = 0l,sum=0l;
        HashMap<Long,Long> mp = new HashMap<>();
        mp.put(0l, 1l);
        for(int i = 0 ; i < s.length ; ++i){
            sum+=s[i]-'0';
            System.out.println("Sum: " +  sum);
            long val = (sum-(i+1));
            if(mp.containsKey(val)){
                System.out.println("map[" +val+"] = "+ mp.get(val));
                res += mp.get(val);
                mp.put(val, mp.get(val)+1);
            }else{
                System.out.println("Created value: map[" +val+"] = 1");
                mp.put(val, 1l);
            }
        }
        return res;
    }
}