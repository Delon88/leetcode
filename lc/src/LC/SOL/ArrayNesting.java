package LC.SOL;

public class ArrayNesting {
    class Solution {
        public int arrayNesting(int[] nums) {
            int n = nums.length;
            boolean[] v = new boolean[n];
            int max = 0 ;
            for ( int i = 0 ; i < nums.length ; i++) {
                max = Math.max(max, dfs(nums, v, i));
            }
            return max;
        }

        int dfs(int[] nums, boolean[] v, int x) {
            int count = 0;
            while ( !v[x] ) {
                v[x] = true;
                x = nums[x];
                count++;
            }
            return count;
        }
    }
}
