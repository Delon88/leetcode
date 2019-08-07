package LC.SOL;

public class PartitionArrayintoDisjointIntervals {
    class Solution {
        public int partitionDisjoint(int[] A) {
            int localMax = A[0], max = localMax, pIndex = 0;
            for (int i = 1; i < A.length; i++) {
                if (localMax > A[i]) {
                    localMax = max;
                    pIndex = i;
                } else {
                    max = Math.max(max, A[i]);
                }
            }
            return pIndex + 1;
        }
    }
}
