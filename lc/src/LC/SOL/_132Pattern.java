package LC.SOL;

import java.util.Stack;

public class _132Pattern {
    public class Solution {
//        public boolean find132pattern(int[] nums) {
//
//            if (nums.length < 3) return false;
//            for (int i = 0; i < nums.length - 2; i++) {
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if ( nums[i] < nums[k] && nums[k] < nums[j]) return true;
//                    }
//                }
//            }
//            return false;
//        }


        class Pair {
            int min, max;

            public Pair(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }

        public boolean find132pattern(int[] nums) {
            Stack<Pair> stack = new Stack<>();
            if (nums == null || nums.length < 3) {
                return false;
            }
            stack.push(new Pair(nums[0], nums[0]));

            for (int i = 1; i < nums.length; i++) {
                if (stack.isEmpty() || nums[i] < stack.peek().min) stack.push(new Pair(nums[i], nums[i]));
                else if (nums[i] > stack.peek().min) {
                    Pair p = stack.pop();
                    if (nums[i] < p.max) return true;
                    else {
                        p.max = nums[i];
                        while (!stack.isEmpty() && nums[i] >= stack.peek().max) stack.pop();
                        if (!stack.isEmpty() && stack.peek().min < nums[i]) return true;
                        stack.push(p);
                    }
                }
            }
            return false;
        }

    }
}
