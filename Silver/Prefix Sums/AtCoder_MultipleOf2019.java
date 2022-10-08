import java.io.*;

public class AtCoder_MultipleOf2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        String S = in.readLine();
        int N = S.length();
        int[] sum = new int[N + 1];
        int[]modFrecuency = new int[2019];
        modFrecuency[0] = 1;
        int pow = 1;
        for(int i = N - 1 ; i > - 1 ; --i){
            sum[i] = (sum[i + 1] + (S.charAt(i)-'0')*pow)%2019;
            pow = (pow * 10)%2019;
            modFrecuency[sum[i]]++;
        }
        long res = 0l;
        for(int i = 0 ; i < 2019 ; ++i){
            res+= (modFrecuency[i]*(modFrecuency[i] - 1))/2;
        }
        in.close();
        out.write(res+"");
        out.flush();
        out.close();
    }
}
