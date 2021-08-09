package LC.SOL;

public class JumpGameV {
    class Solution {
        
        public int maxJumps(int[] arr, int d) {
            int n = arr.length;
            int[] dp = new int[n + 1];
            int max = 0;
            for ( int i= 0 ; i < n ; i++) {
                max = Math.max(dfs(arr, n , i , d , dp), max);
            }    
            return max;
        }

        
        int dfs(int[] arr, int n , int i, int d, int[] dp) {
            if ( dp[i] != 0) return dp[i];
            int ret = 1;
            for ( int j = i + 1 ; j <= Math.min(i + d, n -1 ) && arr[i] > arr[j] ; j++) {
                ret = Math.max( ret, 1 + dfs(arr, n , j , d, dp));
            }
            for ( int j = i - 1; j >= Math.max(i - d , 0) && arr[i] > arr[j]; j--) {
                ret = Math.max(ret , 1 + dfs(arr, n , j , d , dp));
            }
            dp[i] = ret;
            return ret;
        }

    }
}
