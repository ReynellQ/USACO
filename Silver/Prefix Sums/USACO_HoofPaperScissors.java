import java.io.*;
import java.util.Arrays;

public class USACO_HoofPaperScissors {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("hps.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("hps.out"));    
        int N = Integer.valueOf(in.readLine());
        Options[] prefix = new Options[N];
        for(int i = 0 ; i < N ; ++i){
            prefix[i] = new Options();
            if(i != 0){
                prefix[i].plays = prefix[i - 1].plays.clone();
            }
            String op = in.readLine();
            if(op.equals("H")){
                prefix[i].plays[0]++;
            }else if(op.equals("P")){
                prefix[i].plays[1]++;
            }else{
                prefix[i].plays[2]++;
            }
        }
        // System.out.println(Arrays.toString(prefix));
        int max = 0;
        for(int i = 0 ; i < N ; ++i){
            Options L, R;
            L = rangeSum(-1, i, prefix);
            R = rangeSum(i + 1, N - 1, prefix);
            // System.out.println("L: " + L);
            // System.out.println("R: " + R);
            for(int j = 0 ; j < 3 ; ++j){
                for(int k = 0 ; k < 3 ; ++k){
                    max = Math.max(max, L.plays[j] + R.plays[k]);
                }
            }
        }
        out.write(max+"");
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
