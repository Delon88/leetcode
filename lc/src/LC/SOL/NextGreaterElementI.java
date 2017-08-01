package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public class Solution {
//        public int[] nextGreaterElement(int[] findNums, int[] nums) {
//            int[] ret = new int[findNums.length];
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//            for (int i = 0 ; i < findNums.length; i++)  {
//                int index = map.get(findNums[i]);
//                int j = index + 1;
//                for ( ; j < nums.length && nums[j] <= findNums[i]; j++) {
//
//                }
//                if ( j == nums.length ) ret[i] = -1;
//                else ret[i] = nums[j];
//            }
//            return ret;
//        }

        public int[] nextGreaterElement(int[] findNums, int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            int[] ret = new int[findNums.length];
            for (int n : nums) {
                while (!stack.isEmpty() && stack.peek() < n) {
                    map.put(stack.pop(), n);
                }
                stack.push(n);
            }
            for (int i = 0; i < findNums.length; i++) {
                ret[i] = map.getOrDefault(findNums[i], -1);
            }
            return ret;
        }
    }
}
