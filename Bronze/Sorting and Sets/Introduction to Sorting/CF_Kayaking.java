import java.io.*;
import java.util.*;
/*
 * Idea: Ordenar los 2*n números y mediante un doble for bloquear 2 elementos, para crear la diferencia entre los n-1 pares sin estos.
 * Guardar el mínimo de todos los posibles casos.
 */
public class CF_Kayaking {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] w = new int[2*n];
        String[]data = in.readLine().split(" ");
        for(int i = 0 ; i < 2*n ; ++i)
            w[i] = Integer.parseInt(data[i]);
        Arrays.sort(w);
        int diff = 0;
        int res = Integer.MAX_VALUE;
        boolean[] blocked = new boolean[2*n];
        int a = -1, b = -1;
        for(int A = 0 ; A < 2*n ; ++A){
            
            for(int B = A+1 ; B < 2*n ; ++B){
                diff = 0;
                blocked[A] = true;
                blocked[B] = true;
                for(int j = 0 , k = 0 ; j < 2*n; ++j){
                    if(blocked[j])
                        continue;
                    if(k % 2 == 0){
                        a = w[j];
                    }else{
                        b = w[j];
                        diff+= (b-a);
                    }
                    ++k;
                }
                res = Math.min(res, diff);
                blocked[A] = false;
                blocked[B] = false;
            }
            
            
        }
        out.write(res+"");
        out.flush();
    }
}
