import java.io.*;
import java.util.Arrays;

public class USACO_Subsequences_Summing_to_Sevens {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("div7.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("div7.out"));    
        int N = Integer.valueOf(in.readLine());
        int []A = new int[N], prefix = new int[N];
        int[] mod = new int[7];
        Arrays.fill(mod, -1);
        int max = 0;
        for(int i = 0 ; i < N ; ++i){
            A[i] = Integer.valueOf(in.readLine());
            if(i == 0) prefix[i] = A[i] % 7;
            else prefix[i] = (A[i] + prefix[i - 1]) % 7;
            if(mod[prefix[i]] == -1){
                mod[prefix[i]] = i;
            }else{
                max = Math.max(max, i - mod[prefix[i]]);
            }
        }
        System.out.println(Arrays.toString(prefix));
        out.write(max+"");
        out.flush();
        out.close();
    }

}
