package LC.SOL;

public class SmallestRectangleEnclosingBlackPixels {
    class Solution {

        //        An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
//        The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically.
//        Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
//        that encloses all black pixels.
//
//        Example:
//
//        Input:
//                [
//                "0010",
//                "0110",
//                "0100"
//                ]
//        and x = 0, y = 2
//
//        Output: 6
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int minArea(char[][] image, int x, int y) {
            int[] bound = {y, y, x, x};
            dfs(image, x, y, bound);
            return (bound[1] - bound[0]) * (bound[3] - bound[2]);
        }

        void dfs(char[][] image, int x, int y, int[] bound) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != '1') return;
            image[x][y] = '2';
            bound[0] = Math.min(y, bound[0]);
            bound[1] = Math.max(y, bound[1]);
            bound[2] = Math.min(x, bound[2]);
            bound[3] = Math.max(x, bound[3]);
            for (int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                dfs(image, nextX, nextY, bound);
            }
        }
    }
}
