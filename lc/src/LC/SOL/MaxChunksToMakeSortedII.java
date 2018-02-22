package LC.SOL;

public class MaxChunksToMakeSortedII {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] leftMax = new int[arr.length];
            int[] rightMin = new int[arr.length];
            int max = arr[0];
            int min = arr[arr.length -1];
            for ( int i = 0; i < arr.length ;i++) {
                max = Math.max(max, arr[i]);
                leftMax[i] = max;
            }
            for ( int i = arr.length - 1; i >= 0 ; i--) {
                min = Math.min(min, arr[i]);
                rightMin[i] = min;
            }
            int count = 0 ;
            for ( int i = 0 ; i < arr.length  - 1 ; i++) {
                if ( leftMax[i] <= rightMin[i+ 1]) count++;
            }
            return count + 1;
        }
    }
}
