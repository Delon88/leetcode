package LC.SOL;

import java.util.Arrays;

public class _3SumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int ret = nums[0] + nums[1] + nums[2];
            int n = nums.length;
            Arrays.sort(nums);
            for ( int i = 0 ; i < n - 2 ; i++) {
                int j = i + 1 , k = n- 1;
                while ( j < k ) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if ( sum > target ) {
                        k--;
                    } else if ( sum < target) {
                        j++;
                    } else {
                        return sum;
                    }
                    if ( Math.abs(sum - target) < Math.abs(ret - target)) {
                        ret = sum;
                    }
                }
            }
            return ret;
        }
    }
}
