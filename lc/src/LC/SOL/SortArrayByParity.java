package LC.SOL;

public class SortArrayByParity {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            for (int i = 0, j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    i++;
                }
            }
            return A;
        }
    }
}
