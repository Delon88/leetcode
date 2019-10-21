package LC.SOL;

public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            if (nums.length <= 1) return 0;
            int start = 0, end = 0;
            int count = 0;
            while (end < nums.length) {
                int nextEnd = 0;
                count++;
                for (int i = start; i <= end; i++) {
                    nextEnd = Math.max(nextEnd, nums[i] + i);
                }
                start = end;
                end = nextEnd;
                if (nextEnd >= nums.length - 1) return count;
            }
            return -1;
        }
    }

    class SoluttionO {
        public int jump(int[] nums) {
            int ju = 0, max = 0, curEnd = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(max, nums[i] + i);
                if (i == curEnd) {
                    ju++;
                    curEnd = max;
                }
            }
            return ju;
        }
    }
}
