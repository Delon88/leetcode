package LC.SOL;

public class SetMismatch {

    class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            if (n == 0) return new int[0];
            boolean[] exist = new boolean[n + 1];
            int[] ret = {0, 0};
            for (int i = 0; i < nums.length; i++) {
                if (exist[nums[i]]) ret[0] = nums[i];
                else exist[nums[i]] = true;
            }
            for (int i = 1; i <= n; i++) {
                if (!exist[i]) ret[1] = i;
            }
            return ret;
        }
    }

}
