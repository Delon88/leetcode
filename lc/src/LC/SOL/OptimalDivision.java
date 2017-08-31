package LC.SOL;

public class OptimalDivision {
    class Solution {
        public String optimalDivision(int[] nums) {
            StringBuilder b = new StringBuilder();
            if (nums.length == 0) {
                return b.toString();
            }
            if (nums.length == 1) {
                b.append(nums[0]);
                return b.toString();
            }
            if (nums.length == 2) {
                b.append(nums[0]);
                b.append("/");
                b.append(nums[1]);
                return b.toString();
            }

            b.append(nums[0]).append('/').append('(');
            for (int i = 1; i < nums.length - 1; i++) {
                b.append(nums[i]).append('/');
            }
            b.append(nums[nums.length - 1]).append(')');
            return b.toString();
        }
    }
}
