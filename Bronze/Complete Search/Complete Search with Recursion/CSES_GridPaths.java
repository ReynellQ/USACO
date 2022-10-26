import java.io.*;

public class CSES_GridPaths {
    static boolean[][]grid;

    static int[] dirI = {1, -1, 0,  0};
    static int[] dirJ = {0,  0, 1, -1};
    static int recurssion = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        grid = new boolean[7][7];
        String s = in.readLine();
        grid[0][0] = true;
        out.write(bk(s, 0, 0, 0)+"");
        // System.out.println(recurssion);
        in.close();
        out.flush();
        out.close();
    }
    private static int bk(String s, int i, int j, int level) {
        // printState();
        if(i == 6 && j == 0 ){
            return level == s.length() ? 1 : 0;
        }
            
        int count = 0;
        if(s.charAt(level) == 'D'){
            if(isValid(i + 1, j)){
                grid[i + 1][j] = true;
                count+=bk(s, i + 1, j, level+1);
                grid[i + 1][j] = false;
            }
                
        }else if(s.charAt(level) == 'U'){
            if(isValid(i - 1, j)){
                grid[i - 1][j] = true;
                count+=bk(s, i - 1, j, level+1);
                grid[i - 1][j] = false;
            }
                
        }else if(s.charAt(level) == 'L'){
            if(isValid(i , j - 1)){
                grid[i][j - 1] = true;
                count+=bk(s, i , j - 1, level+1);
                grid[i][j - 1] = false;
            }
                
        }else if(s.charAt(level) == 'R'){
            // System.out.println("tengo que ir a la derecha");
            if(isValid(i, j + 1)){
                grid[i][j + 1] = true;
                count+=bk(s, i, j + 1, level+1);
                grid[i][j + 1] = false;
            }
                
        }else{
            boolean[] dirs = new boolean[4];
            for(int index = 0 ; index <4 ; ++index){
                int nI = i + dirI[index];
                int nJ = j + dirJ[index];
                if(isValid(nI, nJ)){
                    dirs[index] = true;
                }
            }
            if( (dirs[0] && dirs[1]) && !(dirs[2] || dirs[3])){
                // System.out.println("Caigo aca");
                return 0;
            }
                
            if( (dirs[2] && dirs[3]) && !(dirs[0] || dirs[1]) ){
                // System.out.println("Caigo aca");
                return 0;
            }
                
            for(int index = 0 ; index <4 ; ++index){
                int nI = i + dirI[index];
                int nJ = j + dirJ[index];
                
                if(dirs[index]){
                    grid[nI][nJ] = true;
                    count+=bk(s, nI, nJ, level+1);
                    grid[nI][nJ] = false;
                }
            }
        }
        return count;
    }
    private static void printState() {

        try {
            for(int i = 0 ; i < 7 ; ++i){
                for(int j = 0 ; j < 7 ; ++j){
                    if(grid[i][j])
                        System.out.print('x');
                    else
                        System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
            Thread.sleep(200);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private static boolean isValid(int nI, int nJ) {
        if( !( nI > -1 && nI < 7 && nJ > -1 && nJ < 7) || grid[nI][nJ])
            return false;
        
        return true;
    }


}
