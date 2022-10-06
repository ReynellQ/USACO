import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("outofplace.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("outofplace.out"));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        int[] cows = new int[N], sorted = new int[N];
        for(int i = 0 ; i < N ; ++i){
            cows[i] =Integer.valueOf(in.readLine());
            sorted[i] = cows[i];
        }
        Arrays.sort(sorted);
        int res = -1;
        for(int i = 0 ; i < N ; ++i){
            if(sorted[i]!=cows[i])
                ++res;
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}