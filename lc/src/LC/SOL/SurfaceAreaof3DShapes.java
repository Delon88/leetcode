package LC.SOL;

public class SurfaceAreaof3DShapes {
    class Solution {
        public int surfaceArea(int[][] grid) {
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] > 0) sum += 4 * grid[i][j] + 2;
                    if (i > 0) sum -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    if (j > 0) sum -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
            return sum;
        }
    }
}
