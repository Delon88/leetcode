package LC.SOL;

public class IslandPerimeter {
    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) count+= cellPeri(i , j  , grid);
                }
            }
            return count;
        }

        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        public int cellPeri(int i, int j, int[][] grid) {
            int c = 0;
            for (int[] d : dirs) {
                int dx = i + d[0];
                int dy = j + d[1];
                if (dx < 0 || dx >= grid.length  || dy < 0 || dy >= grid[0].length ||
                        grid[dx][dy] == 0 ) c++;
            }
            return c;
        }
    }
}
