import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by User on 11/2/2017.
 */
public class Triangle {

    private int side1;
    private int side2;
    private int side3;

    public int solution(int[] A) {


        if (IntStream.of(A).anyMatch(x -> x < 0) || A == null ||
                A.length < 3) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]
                    & A[i + 2] + A[i + 1] > A[i]
                    & A[i + 2] + A[i] > A[i + 1]) {
                int side1 = A[i + 2];
                int side2 = A[i ];
                int side3 = A[i + 1];
                return side1 + side2 + side3;
            }
        }

        return -1;

      /*  Arrays.sort(A);
        for(int i = 0; i < A.length-2; i++) {
            if (A[i] >= 0 && A[i] > A[i+2] - A[i+1]) {
                return 1;
            }
        }
        return 0;*/
    }

    public static void main(String[] args) {
        int[] A = {5, 10, 18, 7, 8, 3};

        Triangle triangle = new Triangle();
        int res = triangle.solution(A);

        System.out.println(res);
    }
}

