package LC.SOL;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
    class Solution {
        // dp[i ,j] = dp[i , k] + dp[k + 1, j] + max[i, k] * max[k + 1, j]
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n], max = new int[n][n];
            for (int i = 0; i < n; i++) {
                int m = 0;
                for (int j = i; j < n; j++) {
                    m = Math.max(m, arr[j]);
                    max[i][j] = m;
                }
            }

            for (int len = 1; len < n; len++) {
                for (int i = 0; i < n - len; i++) {
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;
                    if (len == 1) dp[i][j] = arr[i] * arr[j];
                    else {
                        for (int k = i; k < j; k++) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

    class SolutionON {
        public int mctFromLeafValues(int[] arr) {
            int ret = 0, n = arr.length;
            Stack<Integer> st = new Stack<>();
            st.push(Integer.MAX_VALUE);
            for (int a : arr) {
                while (st.peek() <= a) {
                    int mid = st.pop();
                    ret += mid * Math.min(st.peek(), a);
                }
                st.push(a);
            }
            while ( st.size() > 2) {
                ret += st.pop() * st.peek();
            }
            return ret;
        }
    }
}
