package LC.SOL;

public class BurstBalloons {
    class Solution {
        int[][] memo;
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] ba = new int[n];
            ba[0] = 1; ba[n - 1 ] =1;
            for( int i = 1 ; i < n - 1 ; i++) {ba[i] = nums[i - 1];}
            memo = new int[n][n];
            return dfs(ba , 0 , n - 1);
        }

        int dfs(int[] ba, int start, int end ) {
            if ( start > end ) return 0;
            if ( memo[start][end] > 0 ) return memo[start][end];
            int ret =0;
            for ( int i = start + 1 ; i < end ; i++) {
                ret = Math.max(ret, ba[start] * ba[i] * ba[end] +  dfs(ba, start , i ) + dfs(ba, i , end));
            }
            memo[start][end] = ret;
            return ret;
        }

        public int maxCoins1(int[] nums) {
            int n = nums.length + 2;
            int[][] dp = new int[n][n];
            int[] ba = new int[n];
            ba[0] = 1;ba[n -1] = 1;
            for ( int i = 1 ; i < n - 1 ;i++) ba[i] = nums[i - 1];

            for ( int k = 2 ; k < n ; k++) {
                for ( int left = 0 ; left < n - k ; left++) {
                    int right = left + k;
                    for ( int i = left + 1; i < right ; i++) {
                        dp[left][right] = Math.max(dp[left][right] , ba[left] * ba[i] * ba[right] + dp[left][i] + dp[i][right]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
