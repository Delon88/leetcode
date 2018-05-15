package LC.SOL;

import java.util.Arrays;

public class _3SumSmaller {
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3) return 0;
            Arrays.sort(nums);
            int n = nums.length;
            int count = 0;
            for (int i = 0; i < n - 2; i++) {
                int j = i + 1 ;
                int k = n - 1;
                while ( j < k ) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if ( sum < target) {
                        count+= ( k - j );
                        j++;
                    } else  {
                        k--;
                    }
                }
            }
            return count;
        }
    }
}
