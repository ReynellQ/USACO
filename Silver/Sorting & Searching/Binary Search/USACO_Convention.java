import java.io.*;
import java.util.*;

public class USACO_Convention {
    static int N, M, C;
    static int[] t;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("convention.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("convention.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        t = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < N ; ++i)
            t[i] = Integer.valueOf(st.nextToken());
        Arrays.sort(t);
        in.close();
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    /*
     * Do binary search from 0 to max time required to wait, for each timespan create groups.
     */
    public static int bs(){
        int l = -1, r = Integer.MAX_VALUE - 100, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(notPossible(mid)){
                System.out.println("No se pueden crear grupos con " + mid +" tiempo de espera");
                l = mid;
            }else{
                System.out.println("Si se pueden crear grupos con " + mid +" tiempo de espera");
                r = mid - 1;    
            }
        }
        return l + 1;
    }
    private static boolean notPossible(int timespan) {
        int i = 0, j;
        int groups = 1;
        for(j = 0 ; j < N ; ++j){
            if( (j - i + 1) > C || t[j] - t[i] > timespan){
                groups ++;
                i = j;
            }
        }
        System.out.println("Grupos: " + groups);
        return groups > M;
    }
}
