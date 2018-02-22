package LC.SOL;

public class MaxChunksToMakeSorted {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null || arr.length == 0) return -1;
            int count = 0, max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(arr[i], max);
                if ( max == i) count++;
            }
            return count;
        }
    }
}
