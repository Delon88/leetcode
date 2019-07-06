package LC.SOL;

import java.util.Arrays;

public class _3SumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if ( nums == null || nums.length == 0 ) return -1;
            if ( nums.length < 3 ) {
                int sum = 0;
                for ( int n : nums) {
                    sum += n;
                }
                return sum;
            }
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            int ret = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while ( j < k ) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if ( Math.abs( sum - target) < diff ) {
                        ret = sum;
                        diff = Math.abs(sum - target);
                    }
                    if ( sum < target) { j++;}
                    else if ( sum > target) {k--;}
                    else { return sum;}
                }
            }
            return ret;
        }

    }
}
