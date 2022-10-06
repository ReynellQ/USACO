import java.io.*;

public class USACO_OutOfPlace {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("outofplace.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("outofplace.out"));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        int[] cows = new int[N];
        for(int i = 0 ; i < N ; ++i){
            cows[i] =Integer.valueOf(in.readLine());
        }
        int bessie = -1;
        for(int i = 1 ; i < N ; ++i){
            if(cows[i]<cows[i-1]){
                bessie = i;
                break;
            }
        }
        int hop = cows[bessie];
        int res = 1;
        for(int i = bessie - 1 ; i > -1 ; --i){
            if(cows[i] < cows[bessie])
                break;
            if(cows[i] != hop){
                ++res;
                hop = cows[i];
            }
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
