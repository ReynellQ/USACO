import java.io.*;
import java.util.*;

public class CSES_Labyrinth {
    static char[][] grid;
    static int n, m;
    static int dirI[] = { 1, -1, 0,  0};
    static int dirJ[] = { 0,  0, 1, -1};
    static char dir[] = {'D','U', 'R', 'L'};
    static char[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        grid = new char[n][m];
        res = new char[n][m];
        for(int i = 0 ; i < n ; ++i)
            grid[i] = in.readLine().toCharArray();
        int begin = 0, end = 0;
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                res[i][j] =' ';
                if(grid[i][j] == 'A')
                    begin = i*m + j;
                if(grid[i][j] == 'B')
                    end = i*m + j;  
            }
        }
        bfs(begin, end); 
        // for(int i = 0 ; i < n ; ++i){
        //     for(int j = 0 ; j < m ; ++j){
        //         System.out.print(res[i][j]);
        //     }
        //     System.out.println();
        // }
        Stack<Character> s = new Stack<>();
        int i, j;
        i = end/m;
        j = end % m;
        if(res[i][j] == ' '){
            out.write("NO");
        }else{
            out.write("YES\n");
            while(res[i][j] != 'C'){
                s.add(res[i][j]);
                if(res[i][j] == 'L') ++j;
                else if(res[i][j] == 'R') --j;
                else if(res[i][j] == 'U')  i++;
                else i--;
                
            }
            out.write(s.size()+"\n");
            while(!s.isEmpty())
                out.write(s.pop()+"");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static void bfs(int begin, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(begin);
        int node;
        int i = begin/m;
        int j = begin%m;
        int nI, nJ;
        res[i][j] = 'C';
        while(!q.isEmpty()){
            node = q.poll();
            if(node == end)
                return;
            i = node/m;
            j = node%m;
            for(int d = 0 ; d < 4 ; ++d){
                nI = i + dirI[d];
                nJ = j + dirJ[d];
                if(nI > -1 && nI < n && nJ > -1 && nJ < m && grid[nI][nJ] != '#' && res[nI][nJ] == ' '){
                    res[nI][nJ] = dir[d];
                    q.add(nI*m + nJ);
                }
            }
        }
    }
}
