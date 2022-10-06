import java.io.*;

public class USACO_EvenMoreOddPhotos {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int N = Integer.parseInt(in.readLine());
        data = in.readLine().split(" ");
        int even = 0, odd = 0;
        for(int i = 0 ; i < N ; ++i){
            int a = Integer.valueOf(data[i]);
            if(a % 2 == 0)
                even++;
            else
                odd++;
        }
        while (odd > even) { 
			odd -= 2;
			even++; 
		}
		if (even > odd + 1) {
			even = odd + 1;
		}
        int res = even + odd;
        out.write(res+"");
        out.flush();
    }
}
