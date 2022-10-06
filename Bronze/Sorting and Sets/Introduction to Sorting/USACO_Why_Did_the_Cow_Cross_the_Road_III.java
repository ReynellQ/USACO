import java.io.*;
import java.util.*;
/*
 * Idea: Ordenar las "vacas" por el tiempo en el que llegan, luego empezar a partir del tiempo
 * cow[0].llegada + cow[0].espera. El tiempo de la siguiente vaca es el máximo entre el tiempo
 * actual y el tiempo en el que la vaca llegará, más el tiempo que esta se demore.
 */
public class USACO_Why_Did_the_Cow_Cross_the_Road_III {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter("cowqueue.out");
        int N = Integer.valueOf(in.readLine());
        Cow [] cows = new Cow[N];
        for(int i = 0 ; i < N ; ++i){
            String[]data = in.readLine().split(" ");
            cows[i] = new Cow(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
        }
        Arrays.sort(cows);
        int time = cows[0].a + cows[0].b;
        for(int i = 1 ; i < N ; ++i)
            time = Math.max(time, cows[i].a) + cows[i].b;
        pw.println(time);
        pw.close();
    }
    static class Cow implements Comparable<Cow>{
        int a, b;
        public Cow(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Cow o) {
            return a - o.a;
        }
    }
}
