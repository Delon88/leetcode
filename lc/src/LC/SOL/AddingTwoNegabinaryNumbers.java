package LC.SOL;

import java.util.Stack;

public class AddingTwoNegabinaryNumbers {
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
            Stack<Integer> st = new Stack<>();
            while (i >= 0 || j >= 0 || carry != 0) {
                if (i >= 0) carry += arr1[i--];
                if (j >= 0) carry += arr2[j--];
                st.push(carry & 1);
                carry = -(carry >> 1);
            }
            while ( st.size() > 1 && st.peek() == 0) st.pop();
            int[] ret = new int[st.size()];
            int k = 0;
            while ( !st.isEmpty()) ret[k++] = st.pop();
            return ret;
        }
    }
}
