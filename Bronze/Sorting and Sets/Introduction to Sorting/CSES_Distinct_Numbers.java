import java.io.*;
import java.util.*;
/*
 * Idea: Se ordena el arreglo y se cuentan todas las veces que x[i] != x[i-1]
 */
public class CSES_Distinct_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int n;
        int []x;
        n = Integer.valueOf(in.readLine());
        x = new int[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            x[i] = Integer.valueOf(data[i]);
        Arrays.sort(x);
        int e = 1;
        for(int i = 1 ; i < n ; ++i)
            if(x[i] != x[i-1])
                ++e;
        out.write(e+"");
        out.flush();
    }
}
