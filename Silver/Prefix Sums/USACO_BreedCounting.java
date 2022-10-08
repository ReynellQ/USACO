import java.io.*;
import java.util.*;

public class USACO_BreedCounting {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("bcount.out"));   
        String[]data = in.readLine().split(" "); 
        int N = Integer.valueOf(data[0]);
        int Q = Integer.valueOf(data[1]);
        Options[] prefix = new Options[N];
        for(int i = 0 ; i < N ; ++i){
            prefix[i] = new Options();
            if(i != 0){
                prefix[i].plays = prefix[i - 1].plays.clone();
            }
            int num = Integer.valueOf(in.readLine());
            prefix[i].plays[num-1]++;
        }
        int max = 0;
        for(int i = 0 ; i < Q ; ++i){
            data = in.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(data[0]) - 1;
            b = Integer.parseInt(data[1]) - 1;
            Options q = rangeSum(a, b, prefix);
            for(int j = 0 ; j < 3 ; ++j){
                out.write(q.plays[j] + " ");
            }
            out.write("\n");
        }
        out.flush();
        out.close();
    }
    static Options rangeSum(int L, int R, Options[]arr){
        L--;
        if(L < 0){
            return arr[R];
        }
        Options r = new Options();
        r.plays = arr[R].plays.clone();
        for(int i = 0 ; i < 3 ; ++i){
            r.plays[i] -= arr[L].plays[i];
        }
        return r;
    }
    static class Options{
        int[] plays;
        public Options(){
            this.plays = new int[3];
        }
        @Override
        public String toString() {
            return "Options [plays=" + Arrays.toString(plays) + "]";
        }
        
    }
}
