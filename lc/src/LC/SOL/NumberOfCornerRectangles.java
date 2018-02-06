package LC.SOL;

public class NumberOfCornerRectangles {
    class Solution {
        public int countCornerRectangles(int[][] grid) {
            int ret = 0;
            for (int row1 = 0; row1 < grid.length - 1; row1++) {
                for (int row2 = row1 + 1; row2 < grid.length; row2++) {
                    // calculate corner rectangle
                    int count = 0;
                    for (int i = 0; i < grid[0].length; i++) {
                        if (grid[row1][i] == 1 && grid[row2][i] == 1) count++;
                    }

                    ret += count * (count - 1) / 2;
                }
            }
            return ret;
        }
    }
}
