package LC.SOL;

import java.util.Stack;

public class NumberofValidSubarrays {
    class Solution {
        public int validSubarrays(int[] nums) {
            Stack<Integer> st = new Stack<>();
            int ret = 0;
            for (int n : nums) {
                while ( !st.isEmpty() && n < st.peek()) st.pop();
                st.push(n);
                ret += st.size();
            }
            return ret;
        }
    }
}
