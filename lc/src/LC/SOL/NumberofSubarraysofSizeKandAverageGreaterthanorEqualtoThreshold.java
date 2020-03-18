package LC.SOL;

public class NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {
    class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int sum = 0, count =0;
            for ( int start = -1, end = 0 ; end < arr.length ; end++) {
                sum += arr[end];
                if ( end - start >= k  ) {
                    if ( sum / k >= threshold) count++;
                    sum -= arr[++start];
                }
            }
            return count;
        }
    }
}
