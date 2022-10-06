import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        BufferedWriter out = new BufferedWriter(new PrintWriter("swap.out"));
        String[]data;
        int N, K;
        data = in.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        K = Integer.parseInt(data[1]);
        ArrayList<Integer> g[] = new ArrayList[N + 1];
        for(int i = 1 ; i < N + 1; ++i){
            g[i] = new ArrayList<>();
        }
        int A1, A2, B1, B2;
        data = in.readLine().split(" ");
        A1 = Integer.parseInt(data[0]);
        A2 = Integer.parseInt(data[1]);
        for(int i = 1 ; i < A1 ; ++i)
            g[i].add(i);
        for(int i = A2+1 ; i < N+1 ; ++i)
            g[i].add(i);
        while(A1 < A2){
            g[A1].add(A2);
            g[A2].add(A1);
            A1++;
            A2--;
        }
        if(A1 == A2) g[A1].add(A2);
        data = in.readLine().split(" ");
        B1 = Integer.parseInt(data[0]);
        B2 = Integer.parseInt(data[1]);
        for(int i = 1 ; i < B1 ; ++i)
            g[i].add(i);
        for(int i = B2+1 ; i < N+1 ; ++i)
            g[i].add(i);
        while(B1 < B2){
            g[B1].add(B2);
            g[B2].add(B1);
            B1++;
            B2--;
        }
        if(B1 == B2){
            g[B1].add(B2);
        }
        int[] arr = new int[N+1];
        for(int i = 1 ; i < N+1 ; ++i){
            ArrayList<Integer> pos = new ArrayList<>();
            int e = i;
            int cycle = 0;

            do{
                pos.add(e);
                e = g[e].get(0);
                System.out.println("Va al " + e);

                e = g[e].get(1);
                System.out.println("Luego al " + e);
                ++cycle;
            }while(e!=i);
            System.out.println(pos);
            System.out.println("Cycle: " + cycle);
            System.out.println(K % cycle);
            arr[pos.get(K % cycle)] = i;
        }
        System.out.println("RESPUESTA:");
        for(int i = 1 ; i < N+1 ; ++i){
            out.write(arr[i]+"\n");
        }
        out.flush();
        
    }

}