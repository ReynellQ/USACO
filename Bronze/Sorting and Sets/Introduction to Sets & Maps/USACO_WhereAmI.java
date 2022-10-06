import java.io.*;
import java.util.*;

public class USACO_WhereAmI {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("whereami.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("whereami.out"));
        int N;
        N = Integer.valueOf(in.readLine());
        String s = in.readLine();
        boolean res = false;
        int k = 0;
        while(!res ){
            k++;
            Set<String> words = new HashSet<>();
            words.add(s.substring(0, k));
            res = true;
            for(int i = 1 ; i < N - k + 1; ++i){
                String sub = s.substring(i, i + k);
                if(!words.contains(sub)){
                    words.add(sub);
                }else{
                    res = false;
                    break;
                }
            }
        }
        out.write(k+"");
        out.flush();
    }
}
