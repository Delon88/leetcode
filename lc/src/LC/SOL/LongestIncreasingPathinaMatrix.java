package LC.SOL;

public class LongestIncreasingPathinaMatrix {
    class Solution {
        int[][] memo;
        int[][] dirs = {{1, 0 } , { 0 , 1} , { -1,0} , {0, -1}};
        public int longestIncreasingPath(int[][] matrix) {
            if  ( matrix == null || matrix.length == 0) return 0;
            int m = matrix.length , n = matrix[0].length;
            memo = new int[m][n];
            int max = 0;
            for ( int i = 0 ;i < m ;i++) {
                for ( int j = 0 ; j < n ; j++) {
                    max = Math.max(max, dfs(matrix, i , j));
                }
            }
            return max;
        }

        int dfs(int[][] matrix, int x, int y) {
            if ( memo[x][y] > 0 ) return memo[x][y];
            int len = 1;
            for ( int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                if ( nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length &&
                        matrix[x][y] < matrix[nextX][nextY]) {
                    len = Math.max(len, 1 + dfs(matrix, nextX, nextY));
                }
            }
            memo[x][y] = len;
            return len;
        }
    }
}
