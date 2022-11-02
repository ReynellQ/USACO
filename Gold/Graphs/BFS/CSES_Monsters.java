import java.io.*;
import java.util.*;

public class CSES_Monsters {
    static char[][] res;
    static char[][] grid;
    static int n, m;
    static int dirI[] = { 1, -1, 0,  0};
    static int dirJ[] = { 0,  0, 1, -1};
    static char dir[] = {'D','U', 'R', 'L'};
    static int iA, jA;

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
        for(int i = 0 ; i < n ; ++i)
            for(int j = 0 ; j < m ; ++j)
                res[i][j] = ' ';
        Node achieve = bfs();
        Stack<Character> s = new Stack<>();
        
        if(achieve == null){
            out.write("NO");
        }else{
            int i, j;
            i = achieve.i;
            j = achieve.j;
            out.write("YES\n");
            while(res[i][j] != 'A'){
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
    static Node bfs(){
        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                if(grid[i][j] == 'A'){
                    iA = i;
                    jA = j;
                    res[i][j] = 'A';
                }else if(grid[i][j] == 'M'){
                    q.add(new Node('M', i, j));
                    res[i][j] = 'M';
                }
            }
        }
        q.add(new Node('A', iA, jA));
        while(!q.isEmpty()){
            Node node = q.poll();
            if( (node.i == 0 || node.i == n -1 || node.j == 0 || node.j == m - 1) && node.t == 'A'){
                return node;
            }
                
            for(int d = 0 ; d < 4 ; ++d){
                int nI = node.i + dirI[d];
                int nJ = node.j + dirJ[d];
                if(nI > -1 && nI < n && nJ > -1 && nJ < m && res[nI][nJ] == ' ' && grid[nI][nJ] != '#'){
                    res[nI][nJ] = (node.t == 'M') ? 'M' : dir[d];
                    q.add(new Node(node.t, nI, nJ));
                }
            }
        }
        return null;
    }
    static class Node{
        char t;
        int i, j;
        public Node(char t, int i, int j) {
            this.t = t; this.i = i; this.j = j;
        }
    }
}
