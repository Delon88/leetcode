package LC.SOL;

public class ValidMountainArray {
    class Solution {
        public boolean validMountainArray(int[] A) {
            int i = 0, j = A.length - 1;
            while (i + 1 < A.length && A[i] < A[i + 1]) i++;
            while (j > 0 && A[j - 1] > A[j]) j++;
            return i > 0 && j < A.length - 1 && i == j ;
        }
    }
}
