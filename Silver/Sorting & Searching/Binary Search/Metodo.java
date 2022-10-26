import java.util.Arrays;
public class Metodo {
    public static void main(String[] args) {
        int[]A = {1,1,1,1,1,2,2,2,2};
        Metodo m = new Metodo();
        m.metodoMisterio(A, A.length);
        System.out.println(Arrays.toString(A));
    }

    
    public void metodoMisterio(int[] A, int N) {
        if (N == 1)
            return;
        int i = A.length - 2;
        int j = A.length - 1;
        while (i >= 0 && A[i] >= A[i + 1])
            i--;
        if (i >= 0) {
            while (A[j] <= A[i])
                j--;
            swap(A, i, j);  // Metodo que, en O(1), intercambia los
                            // elementos de las posiciones i y j del arreglo
        }
        ++i;
        j = A.length - 1;
        while (i < j) {
            swap(A, i, j);
            ++i;
            --j;
        }
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
