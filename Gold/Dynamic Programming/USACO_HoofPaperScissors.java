import java.io.*;
import java.util.StringTokenizer;

/*
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=694
 */
public class USACO_HoofPaperScissors {
    static final int MAX_N = 100010, MAX_K = 22;
    static int N, K;
    static int HOOF = 0, SICSSORS = 1, PAPER = 2;
    static int DP[][][] = new int[MAX_N][MAX_K][3];
    static int[] plays;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("hps.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("hps.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        plays = new int[N + 1];
        for(int i = 1 ; i < N + 1 ; ++i){
            String OP = in.readLine();
            if(OP.equals("H")) plays[i] = HOOF;
            else if(OP.equals("S")) plays[i] = SICSSORS;
            else plays[i] = PAPER;
        } 
        in.close();
        for(int i = 0 ; i <= N ; ++i){
            for(int j = 0 ; j <= K ; ++j){
                for(int k = 0 ; k < 3 ; ++k){
                    DP[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < 3 ; ++i){
            ans = Math.max(ans, solve(N, K, i));
        }
        out.write(ans+"");
        
        out.flush();
        out.close();
    }
    private static int solve(int n, int k, int play) {
        if(n <= 0)
            return 0;
        if(k < 0)
            return Integer.MIN_VALUE;
        if(DP[n][k][play] != Integer.MIN_VALUE)
            return DP[n][k][play];
        int win = ( (play + 1)%3 == plays[n] )? 1: 0;
        int ans = 0;
        ans+= Math.max(ans, win + solve(n - 1, k, play));
        ans= Math.max(ans, win + solve(n - 1, k - 1, (play + 1)%3));
        ans= Math.max(ans, win + solve(n - 1, k - 1, (play + 2)%3));
        
        return DP[n][k][play] = ans;
    }
}
