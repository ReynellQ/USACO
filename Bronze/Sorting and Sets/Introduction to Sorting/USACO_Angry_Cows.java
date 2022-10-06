import java.io.*;
import java.util.*;
/*
 * Idea: Por cada elemento, evaluar cuánto logra explotar, previamente ordenando el arreglo para calcular
 * esto por cada elemento en O(n).
 */
public class USACO_Angry_Cows {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter("angry.out");
        String[]data;
        int N = Integer.valueOf(in.readLine());
        int[]x = new int[N];
        for(int i = 0 ; i < N ; ++i)
            x[i] = Integer.valueOf(in.readLine());
        Arrays.sort(x);
        int res = 0;
        for(int i = 0 ; i < N ; ++i){
            res = Math.max(res, calc(i, x));
            System.out.println("-------------");
        }
        pw.println(res);
        in.close();
        pw.close();
    }

    private static int calc(int i, int[] x) {
        int total = 1;
        int radius = 1;
        int bomb = i, newBomb ;
        while( (newBomb = nextBombRight(bomb, x, radius)) != bomb){
            System.out.println("Bomba: " + x[bomb] +" alcanzó a " + x[newBomb] +" con radio " + radius);
            total+= newBomb-bomb;
            ++radius;
            bomb = newBomb;
        }
        radius = 1;
        bomb = i;
        while( (newBomb = nextBombLeft(bomb, x, radius)) != bomb){
            System.out.println("Bomba: " + x[bomb] +" alcanzó a " + x[newBomb] +" con radio " + radius);
            total+= bomb-newBomb;
            ++radius;
            bomb = newBomb;
        }
        return total;
    }
    public static int nextBombRight(int i, int[] x, int radius){
        int j = i+1;
        int bomb = x[i];
        while(j < x.length && bomb+radius >= x[j])
            ++j;
        return j-1;
    }
    public static int nextBombLeft(int i, int[] x, int radius){
        int j = i-1;
        int bomb = x[i];
        while(j > -1 && bomb-radius <= x[j])
            --j;
        return j+1;
    }
}
