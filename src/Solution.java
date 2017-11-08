import java.util.HashSet;

/**
 * Created by User on 11/2/2017.
 */
class Solution {
    public int solution(int[] A) {
        int num = 1;
        HashSet<Integer> hset = new HashSet<Integer>();

        for (int i = 0 ; i < A.length; i++) {
            hset.add(A[i]);

            while (hset.contains(num)) {
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int [] a = {5,2,3,4,1};

        Solution solution = new Solution();
        int res = solution.solution(a);

        System.out.println(res);
    }
}
