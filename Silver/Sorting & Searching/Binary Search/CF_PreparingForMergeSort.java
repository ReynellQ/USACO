import java.io.*;
import java.util.*;

public class CF_PreparingForMergeSort {
    static ArrayList<TreeSet<Integer>> sets;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.valueOf(in.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        in.close();
        sets = new ArrayList<>();
        TreeSet<Integer> init = new TreeSet<>();
        init.add(a[0]);
        sets.add(init);
        for(int i = 1 ; i < n ; ++i){
            int index = bs(a[i]);
            if(index == sets.size()){
                init = new TreeSet<>();
                init.add(a[i]);
                sets.add(init);
            }else{
                sets.get(index).add(a[i]);
            }
        }
        for(TreeSet<Integer> set : sets){
            for(Integer x : set){
                out.write(x+" ");
            }
            out.write("\n");
        }
        out.flush();
        out.close();
    }
    static int bs(int x){
        int l = -1, r = sets.size() - 1, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(notPossible(mid, x)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private static boolean notPossible(int index, int x) {
        if(index == -1)
            return true;
        return sets.get(index).last() > x ;
    }
}
