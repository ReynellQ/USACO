/*
 * https://codeforces.com/problemset/problem/701/C
 */
import java.io.*;
import java.util.*;

public class CF_TheyAreEverywhere {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n;
        n = Integer.valueOf(in.readLine());
        String s;
        s = in.readLine();
        TreeSet<Character> unique = new TreeSet<>();
        TreeMap<Character, Integer> set = new TreeMap<>();
        for(int i = 0 ; i < s.length() ; ++i){
            unique.add(s.charAt(i));
        }
        int l = 0, r = 0;
        int res = Integer.MAX_VALUE;
        for( r = 0 ; r < n ; ++r){
            set.put(s.charAt(r), set.getOrDefault(s.charAt(r), 0) + 1);
            while(l < r && set.getOrDefault(s.charAt(l), 0) > 1){
                set.put(s.charAt(l), set.get(s.charAt(l)) - 1);
                l++;
            }
            // System.out.println("L: " + l + ", R: " + r);
            if(set.size() == unique.size()){
                res = Math.min(res, r - l + 1);
            }
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
