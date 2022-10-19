import java.io.*;
import java.util.*;

public class USACO_CountingHaybales {
    static int N, Q;
    static int[] haybales;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("haybales.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("haybales.out"));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        N = Integer.valueOf(st.nextToken());
        Q = Integer.valueOf(st.nextToken());
        haybales = new int[N];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < N ; ++i){
            haybales[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(haybales);
        for(int i = 0 ; i < Q ; ++i){
            st = new StringTokenizer(in.readLine());
            int A, B;
            A = Integer.valueOf(st.nextToken());
            B = Integer.valueOf(st.nextToken());
            A = bs(A - 1);
            B = bs(B);
            out.write((B - A)+"\n");
        }
        in.close();
        Arrays.sort(haybales);
        
        out.flush();
        out.close();
    }
    public static int bs(int value){
        int l = -1, r = N - 1, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(mid == -1 || haybales[mid] <= value){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;    
            }
        }
        return l + 1;
    }
    
}
