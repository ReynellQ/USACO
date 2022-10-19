import java.io.*;
import java.util.*;

public class CF_MagicShip {
    static long x1, x2, y1, y2;
    static int n;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        x1 = Integer.valueOf(st.nextToken());
        y1 = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        x2 = Integer.valueOf(st.nextToken());
        y2 = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(in.readLine());
        s = in.readLine();
        in.close();
        out.write(bs()+"");
        out.flush();
        out.close();
    }
    private static long bs() {
        long max = Long.MAX_VALUE - 100;
        long l = 0, r = max, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(notPossible(mid)){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;    
            }
        }
        return l + 1 > max ? -1 : l + 1;
    }
    private static boolean notPossible(long days) {
        long posX = x1, posY = y1;
        long trip = days / n;
        for(int i = 0 ; i <  n; ++i){
            int index = i % n;
            if(s.charAt(index) == 'U'){
                posY+= trip;
            }else if(s.charAt(index) == 'D'){
                posY-= trip;
            }else if(s.charAt(index) == 'R'){
                posX+= trip;
            }else{
                posX-= trip;
            }
            // System.out.println("Posicion actual: " + posX + ", " + posY);
        }
        for(int i = 0 ; i < days % n; ++i){
            int index = i % n;
            if(s.charAt(index) == 'U'){
                posY++;
            }else if(s.charAt(index) == 'D'){
                posY--;
            }else if(s.charAt(index) == 'R'){
                posX++;
            }else{
                posX--;
            }
            // System.out.println("Posicion actual: " + posX + ", " + posY);
        }
        long moves = Math.abs(posY - y2 ) + Math.abs(posX -  x2);
        // System.out.println("Moves: " + moves);
        // System.out.println("Dias: " + days);
        return moves > days;
    }
}
