package LC.SOL;


import java.util.Arrays;

public class MatchstickstoSquare {
    public class Solution {
        public boolean makesquare(int[] nums) {
            if ( nums == null || nums.length == 0 ) return false;
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if (sum % 4 != 0) return false;
            Arrays.sort(nums);
            reverse(nums);

            return dfs( nums , 0 , new int[4], sum / 4);
        }

        boolean dfs(int[] nums, int index, int[] sums, int target) {
            if (index == nums.length) {
                if (sums[0] == target && sums[1] == target && sums[2] == target) {
                    return true;
                } else {
                    return false;
                }
            }

            for (int i = 0; i < 4 ; i++) {
                if ( sums[i] + nums[index] > target) continue;
                sums[i] +=  nums[index];
                if ( dfs( nums, index + 1 , sums, target)) return true;
                sums[i] -= nums[index];
            }
            return false;
        }

        void reverse(int[] nums) {
            for (int i = 0; i < nums.length / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = tmp;
            }
        }

    }
}
