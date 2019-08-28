package LC.SOL;

import java.util.Arrays;
import java.util.Stack;

public class FindtheShortestSuperstring {
    class Solution {
        public String shortestSuperstring(String[] A) {
            int n = A.length;
            int[][] dist = new int[n][n];
            // calculute the dist between two strings
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = dist(A[i], A[j]);
                    dist[j][i] = dist(A[j], A[i]);
                }
            }

            int[][] dp = new int[1 << n][n];
            int[][] path = new int[1 << n][n];
            int last = -1, min = Integer.MAX_VALUE;
            for (int i = 1; i < (1 << n); i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & i) > 0) {
                        int prev = i - (1 << j);
                        if (prev == 0) {
                            dp[i][j] = A[j].length();
                        } else {
                            for (int k = 0; k < n; k++) {
                                if ( dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + dist[k][j] < dp[i][j]  ) {
                                    dp[i][j] = dp[prev][k] + dist[k][j];
                                    path[i][j] = k;
                                }
                            }
                        }
                    }
                    if ( i == (1 << n) - 1 && dp[i][j] < min) {
                        min = dp[i][j];
                        last = j;
                    }
                }
            }
            // build the
            Stack<Integer> st = new Stack<>();
            int cur = ( 1 << n ) - 1;
            while ( cur > 0 ) {
                st.push(last);
                int tmp = cur;
                cur = cur - ( 1 << last);
                last = path[tmp][last];
            }
            StringBuilder b = new StringBuilder();
            int i = st.pop();
            b.append(A[i]);
            while ( !st.isEmpty()) {
                int j = st.pop();
                b.append(A[j].substring(A[j].length() - dist[i][j]));
                i = j;
            }
            return b.toString();
        }

        // abc bcd
        int dist(String A, String B) {
            for (int i = 1; i < A.length(); i++) {
                if (B.startsWith(A.substring(i))) {
                    return B.length() - (A.length() - i);
                }
            }
            return B.length();
        }
    }
}
