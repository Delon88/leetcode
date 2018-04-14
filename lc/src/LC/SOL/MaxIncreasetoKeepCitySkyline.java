package LC.SOL;

public class MaxIncreasetoKeepCitySkyline {
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] leftRight = new int[grid.length];
            int[] topBot = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    leftRight[i] = Math.max(leftRight[i], grid[i][j]);
                    topBot[j] = Math.max(topBot[j], grid[i][j]);
                }
            }

            int ret =0 ;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    ret += Math.max(Math.min(leftRight[i] , topBot[j]) - grid[i][j], 0);
                }
            }
            return ret;
        }
    }
}
