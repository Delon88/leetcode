package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class SplitArraywithEqualSum {
    class Solution {
        public boolean splitArray(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n];
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            for (int j = 3; j < nums.length - 3; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 1; i < j - 1; i++) {
                    if (sum[i - 1] == sum[j - 1] - sum[i]) set.add(sum[i - 1]);
                }
                for ( int k = j + 2 ; k < n - 1; k++) {
                    if ( sum[k -1 ] - sum[j] == sum[n - 1] - sum[k] && set.contains(sum[k -1 ] - sum[j])) return true;
                }
            }
            return false;
        }
    }
}
