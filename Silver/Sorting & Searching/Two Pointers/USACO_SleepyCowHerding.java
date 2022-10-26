import java.io.*;
import java.util.*;

public class USACO_SleepyCowHerding {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader in = new BufferedReader(new FileReader("herding.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("herding.out"));
        StringTokenizer st;
        int N = Integer.valueOf(in.readLine());
        int [] cows = new int[N];
        for(int i = 0 ; i < N ; ++i)
            cows[i] = Integer.valueOf(in.readLine());
        Arrays.sort(cows);
        int total = 0;
        for (int i = 0; i < N; i++) {
			if(i > 0)
				total += (cows[i]-cows[i-1]-1);
		}
        int min = Integer.MAX_VALUE, max = 0;
        if (cows[N-2]-cows[0] == N-2 && cows[N-1]-cows[N-2]>2 || cows[N-1]-cows[1] == N-2 && cows[1]-cows[0]>2) {
			min = 2;
		}else{
            int l = 0, r = 0; 
            for( ; r < N ; ++r){
                int count;
                while(l <= r && cows[l] + N - 1 < cows[r]){
                    l++;
                    count = r -  l + 1;
                } 
                count = r -  l + 1;
                min = Math.min(N - count, min);  
            }
        }
        max = Math.max( total - (cows[1] - cows[0] - 1), total - (cows[N - 1] - cows[N - 2] - 1));
        out.write(min+"\n"+max);
        out.flush();
        out.close();
    }
}
