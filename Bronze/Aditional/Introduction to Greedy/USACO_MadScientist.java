import java.io.*;
import java.util.*;

public class USACO_MadScientist {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("breedflip.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("breedflip.out"));
        int N = Integer.parseInt(in.readLine());
        String A, B;
        A = in.readLine();
        B = in.readLine();
        int diff = A.charAt(0) != B.charAt(0) ? 1 : 0;

        for(int i = 1 ; i < N ; ++i){
            if(A.charAt(i)!=B.charAt(i)){
                if(A.charAt(i - 1)==B.charAt(i - 1)){
                    ++diff;
                }
            }
        }
        out.write(diff+"");
        out.flush();
        
    }
}
