package LC.SOL;

public class PartitiontoKEqualSumSubsets {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for ( int n : nums) sum+= n;
            if ( k <= 0 || sum % k != 0 ) return false;
            return canPartion(nums, new boolean[nums.length], k , 0 , 0 , 0,  sum / k);
        }

        boolean canPartion(int[] nums, boolean[] v, int k, int start, int curSum, int numCount, int target) {
            if (k == 1) return true;
            if (target == curSum && numCount > 0) return canPartion(nums, v, k - 1, 0, 0, 0, target);
            for ( int i = start ; i < nums.length ; i++) {
                if ( !v[i] ) {
                    v[i]  = true;
                    numCount++;
                    if ( canPartion(nums, v , k , i + 1 , curSum + nums[i] , numCount, target )) return true;
                    v[i] = false;
                }
            }
            return false;
        }
    }
}
