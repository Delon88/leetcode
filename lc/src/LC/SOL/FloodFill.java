package LC.SOL;

public class FloodFill {
    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            dfs(image, new boolean[image.length][image[0].length], sr, sc, newColor, image[sr][sc]);
            return image;
        }

        void dfs(int[][] image, boolean[][] v, int x, int y, int newColor, int oldColor) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor || v[x][y])
                return;
            v[x][y] = true;
            image[x][y] = newColor;
            for (int[] d : dirs) {
                dfs(image, v, x + d[0], y + d[1], newColor, oldColor);
            }
        }
    }
}
