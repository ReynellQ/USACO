import java.io.*;

public class ShellGame {
    static class Tuple {
        int a, b, g;

        public Tuple(int a, int b, int g) {
            this.a = a;
            this.b = b;
            this.g = g;
        }

    }

    static void swap(int a, int b, int[] arr) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        String[] data;
        int N;
        int a, b, g;
        N = Integer.valueOf(in.readLine());
        Tuple[] op = new Tuple[N];
        for (int i = 0; i < N; ++i) {
            data = in.readLine().split(" ");
            a = Integer.valueOf(data[0]);
            b = Integer.valueOf(data[1]);
            g = Integer.valueOf(data[2]);
            op[i] = new Tuple(a, b, g);
        }
        int max = 0;
        for (int G = 0; G < 3; ++G) {
            int[] shells = new int[3];
            int guess = 0;
            shells[G] = 1;
            for (int i = 0; i < N; ++i) {
                Tuple t = op[i];
                swap(t.a - 1, t.b - 1, shells);
                if (shells[t.g - 1] == 1) {
                    ++guess;
                }
            }
            max = Math.max(max, guess);
        }
        pw.println(max);
        pw.close();
    }
}
