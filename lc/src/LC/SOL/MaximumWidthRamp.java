package LC.SOL;


import java.util.Stack;

public class MaximumWidthRamp {
    class Solution {
        public int maxWidthRamp(int[] A) {
            Stack<Integer> st = new Stack<>();
            int ret = 0, n = A.length;
            for (int i = 0; i < A.length; i++) {
                if (st.isEmpty() || A[st.peek()] > A[i]) {
                    st.push(i);
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && A[i] >= A[st.peek()]) {
                    ret = Math.max(i - st.pop(), ret);
                }
            }
            return ret;
        }
    }
}
