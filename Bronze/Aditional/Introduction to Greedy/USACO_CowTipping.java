import java.io.*;
import java.util.PriorityQueue;

public class USACO_CowTipping {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowtip.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("cowtip.out"));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        boolean[][] grid = new boolean[N][N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            char[] s = in.readLine().toCharArray();
            for(int j = 0 ; j < N ; ++j){
                grid[i][j] = s[j] == '1';
                if(grid[i][j])
                    pq.add(new Pair(i, j));
            }
        }
        in.close();
        int res = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(!grid[p.a][p.b])
                continue;
            for(int i = 0 ; i <= p.a ; ++i){
                for(int j = 0 ; j <= p.b ; ++j){
                    grid[i][j] = !grid[i][j];
                    if(grid[i][j])
                        pq.add(new Pair(i, j));
                }
            }
            ++res;
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
    static class Pair implements Comparable<Pair>{
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair o) {
            return -1*(a - o.a != 0 ? a - o.a : b - o.b);
        }
    }
}