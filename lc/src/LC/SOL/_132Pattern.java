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
            for ( int n : nums) {
                if ( stack.isEmpty() || n < stack.peek().min ) stack.push(new Pair(n , n ));
                else if ( n > stack.peek().min) {
                    Pair p = stack.pop();
                    if ( n < p.max ) return true;
                    else {
                        p.max = n;
                        while ( !stack.isEmpty() && n >= stack.peek().max ) stack.pop();
                        if ( !stack.isEmpty() && n > stack.peek().min) return true;
                        stack.push(p);
                    }
                }
            }
            return false;
        }

    }
}
