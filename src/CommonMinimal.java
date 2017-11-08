import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by User on 11/2/2017.
 */
public class CommonMinimal {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;

        if ((IntStream.of(A).anyMatch(x -> x < 0))|| (IntStream.of(B).anyMatch(x -> x < 0))){
            throw new IllegalArgumentException();
        }

       /* for (int j = 0; j < A.length; j++) {
            if (A[j] < 0){
                throw new IllegalArgumentException();
            }
        }

        for (int p = 0; p < A.length; p++) {
            if (B[p] < 0){
                throw new IllegalArgumentException();
            }
        }*/

        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] A = {15,42,3,4,16,};
        int [] B = {155,426,345,74,167, 0, -1};
        //int [] B = {56,25,3,4,15};

        CommonMinimal solution = new CommonMinimal();
        int res = solution.solution(A, B);
        System.out.println(res);
    }
}
