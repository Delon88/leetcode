package LC.SOL;

import java.util.Stack;

public class SumofSubarrayMinimums {
    class Solution {
        public int sumSubarrayMins(int[] A) {
            int len = A.length;
            Stack<int[]> prev = new Stack<>();
            Stack<int[]> next = new Stack<>();
            int[] left = new int[len], right = new int[len];
            for (int i = 0; i < A.length; i++) {
                while (!prev.isEmpty() && A[i] <= prev.peek()[0]) {
                    prev.pop();
                }
                left[i] = prev.isEmpty() ? i + 1 : i - prev.peek()[1];
                prev.push(new int[]{A[i], i});
            }
            for (int i = len - 1; i >= 0; i--) {
                while (!next.isEmpty() && A[i] < next.peek()[0]) {
                    next.pop();
                }
                right[i] = next.isEmpty() ? len - i : next.peek()[1] - i;
                next.push(new int[]{A[i], i});
            }
            int ret = 0;
            int mod = 1000000007;
            for (int i = 0; i < A.length; i++) {
                ret = (ret + A[i] * left[i] * right[i]) % mod;
            }
            return ret;
        }
    }
}
