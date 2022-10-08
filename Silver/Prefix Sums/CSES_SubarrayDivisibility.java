import java.io.*;

public class CSES_SubarrayDivisibility {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));   
        String[]data; 
        int N = Integer.valueOf(in.readLine());
        data = in.readLine().split(" ");
        int[]a;
        a = new int[N + 1];
        long[] modFrecuency = new long[N];
        a[0] = 0;
        modFrecuency[0] = 1;
        for(int i = 0 ; i < N ; ++i){
            int x = Integer.valueOf(data[i]);
            a[i + 1] = (a[i] + x)  % N;
            if(a[i + 1] < 0)
                a[i + 1]+=N;
            modFrecuency[a[i + 1]] ++;
        }
        long res = 0l;
        for(int i = 0 ; i < N ; ++i){
            res+= (modFrecuency[i]*(modFrecuency[i] - 1))/2;
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
