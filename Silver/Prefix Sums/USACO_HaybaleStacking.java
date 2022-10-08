import java.io.*;
import java.util.*;

public class USACO_HaybaleStacking {
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
            return left + right;
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
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));   
        String[]data; 
        data = in.readLine().split(" ");
        int N = Integer.valueOf(data[0]);
        int K = Integer.valueOf(data[1]);
        ST tree = new ST(new int[N], 0, N - 1);
        for(int i = 0 ; i < K ; ++i){
            int A, B;
            data = in.readLine().split(" ");
            A = Integer.valueOf(data[0]);
            B = Integer.valueOf(data[1]);
            tree.update(tree.query(A - 1, A - 1) + 1, A - 1);
            if(B != N){
                tree.update(tree.query(B, B) - 1, B);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(N);
        for(int i = 0 ; i < N ; ++i)
            arr.add(tree.query(0, i));
        Collections.sort(arr);
        out.write(arr.get(N/2)+"");
        out.flush();
        out.close();
    }
}
