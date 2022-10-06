import java.io.*;
import java.util.*;
/*
 * Idea: Guardar en un multiset (Map) todos los elementos distintos de A y la
 * cantidad de veces que estos se repiten, y guardar en otro multiset la cantidad de 
 * elementos de C que indican los indices para B. Por cada B[i], comprobar que este esté almacenado
 * en C indicando que sea un índice válido, y comprobar que exista en A. Finalmente, multiplicar
 * las frecuencias de ambos y acumularlas.
 */
public class AtCoder_MadeUp {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        HashMap<Integer, Integer> A = new HashMap<>();
        HashMap<Integer, Integer> C = new HashMap<>();
        int[]B;
        int N = Integer.parseInt(in.readLine());
        data = in.readLine().split(" ");
        for(int i = 0 ; i < N ; ++i){
            int e = Integer.parseInt(data[i]);
            if(A.containsKey(e))
                A.put(e, A.get(e) + 1);
            else
                A.put(e, 1);
        }
        B = new int[N];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < N ; ++i)
            B[i] = Integer.parseInt(data[i]);
        data = in.readLine().split(" ");
        for(int i = 0 ; i < N ; ++i){
            int e = Integer.parseInt(data[i]);
            if(C.containsKey(e))
                C.put(e, C.get(e) + 1);
            else
                C.put(e, 1);
        }

        long res = 0l;
        for(int i = 0 ; i < N ; ++i)
            if(C.containsKey(i + 1) && A.containsKey(B[i]))
                res+= C.get(i + 1)*A.get(B[i]);
        out.write(res +"");
        out.flush();
    }
}
