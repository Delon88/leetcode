package LC.SOL;

import java.util.Arrays;
import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing {
    class Solution {
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            if ( arr1.length == 1) return 0;
            int n = arr1.length;
            TreeSet<Integer> set = new TreeSet<>();
            for ( int a : arr2) set.add(a);
            int[][] dp = new int[n + 1][n + 1];
            for ( int[]  d : dp) Arrays.fill(d , Integer.MAX_VALUE);
            dp[0][0] = Integer.MIN_VALUE;
            for ( int j = 1 ; j <= n; j++) {
                for ( int i = 0; i <= j ; i++) {
                    if ( arr1[j - 1] > dp[i][j - 1]) {
                        dp[i][j] = arr1[j -1];
                    }
                    if ( i > 0 && set.higher(dp[i - 1][j - 1]) != null ) {
                        dp[i][j] = Math.min(dp[i][j], set.higher(dp[i- 1][j -1]));
                    }
                    if ( j == n && dp[i][j] != Integer.MAX_VALUE) return i;
                }
            }
            return -1;
        }
    }
}
