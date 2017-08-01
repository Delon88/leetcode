package LC.SOL;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length  ;
            int[] ret = new int[n];
            Arrays.fill(ret, -1);

            for ( int i =0 ; i < n * 2  ; i++) {
                int num = nums[i % n ];
                while ( !stack.isEmpty() && nums[stack.peek()] < num) {
                    ret[stack.pop()] = num;
                }
                if ( i < n ) stack.push(i);
            }
            return ret;
        }
    }
}
