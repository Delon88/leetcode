package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int[] pre = new int[n];
            int[] dp = new int[n];
            int max = 0, index = -1;
            for ( int i = 0 ; i < n ;i++) {
                dp[i] = 1; pre[i] = -1;
                for ( int j = 0; j < i ; j++) {
                    if ( nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                        pre[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
                if ( dp[i] > max) {
                    max = dp[i]; index = i;
                }
            }
            List<Integer> ret = new ArrayList<>();
            while ( index != -1 ) {
                ret.add(nums[index]);
                index = pre[index];
            }
            return ret;
        }
    }
}
