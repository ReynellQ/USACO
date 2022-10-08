import java.io.*;

public class AtCoder_GCDOnBlackboard {
    static class ST{
        public int value; // El valor cambia con el problema
        ST l;
        ST r;
        int begin, end, mid;
        ST(int[]arr, int i, int j){
            begin = i; end = j; mid = (i+j)/2;
            if(begin == end)
                value = arr[begin];
            else{
                l = new ST(arr, begin, mid);r = new ST(arr,mid + 1, end);
                this.value = merge(l.value, r.value);
            }
        }
        private int merge(int left, int right){
            return gcd(left, right);
        }
        public int query(int i, int j){
            if(i == begin && j == end){
                return value;
            }else{
                if(i <= mid && j <= mid) return l.query(i, j);
                if(i > mid) return r.query(i, j); 
                return merge(l.query(i, mid), r.query(mid+1, j)); 
            }
        }
        public void update(int a, int i){
            if(begin == end && begin == i)
                value = a;
            else{
                if(i <= mid) l.update(a, i);  
                else r.update(a, i);
                value = merge(l.value, r.value);
            }
        }   
        public int gcd(int a, int b){
            if(b == 0)
                return a;
            return gcd(b , a % b);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int N = Integer.valueOf(in.readLine());
        data = in.readLine().split(" ");
        int[]A = new int[N];
        for(int i = 0 ; i < N ; ++i)
            A[i] = Integer.valueOf(data[i]);
        in.close();
        ST tree = new ST(A, 0, N - 1);
        int max = 0;
        for(int i = 0 ; i < N ; ++i){
            int gcd;
            if(i == 0){
                gcd = tree.query(1, N - 1);
            }else if(i == N - 1){
                gcd = tree.query(0, N - 2);
            }else{
                gcd = tree.gcd(tree.query(0, i - 1), tree.query(i + 1, N - 1));
            }
            max = Math.max(max, gcd);
        }
        out.write(max+"");
        out.flush();
        out.close();
    }
}
