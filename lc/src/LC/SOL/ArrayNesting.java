package LC.SOL;

public class ArrayNesting {
    class Solution {
        public int arrayNesting(int[] nums) {
            boolean[] v = new boolean[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!v[i]) max = Math.max(dfs(nums, v, i), max);
            }
            return max;
        }

        int dfs(int[] nums, boolean[] v, int i) {
            int count = 0;
            while (!v[i]) {
                v[i] = true;
                i = nums[i];
                count++;
            }
            return count;
        }
    }
}
