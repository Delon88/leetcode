package LC.SOL;

public class SmallestRotationwithHighestScore {
    class Solution {
        public int bestRotation(int[] A) {
            int n = A.length;
            int[] change = new int[n];
            for (int i = 0; i < n; i++) {
                change[(i - A[i] + n + 1) % n]--;
            }
            int max_i = 0;
            for (int i = 1; i < n; i++) {
                change[i] += change[i - 1] + 1;
                if ( change[max_i] < change[i]) {
                    max_i = i;
                }
            }
            return max_i;
        }
    }
}
