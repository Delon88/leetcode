package LC.SOL;

import java.util.List;

public class NumberofPathswithMaxScore {
    class Solution {
        private final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
        public int[] pathsWithMaxScore(List<String> board) {
            int m = board.size(), n = board.get(0).length();
            int[][] sum = new int[m][n];
            int[][] path = new int[m][n];
            path[m - 1][n - 1] = 1; // start at the bottom right square
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (path[i][j] == 0) continue; // can't reach to this square
                    for (int[] dir : DIRS) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if ( ni >= 0 && nj >= 0 && board.get(ni).charAt(nj) != 'X') {
                            int tmpSum = sum[i][j];
                            if ( board.get(ni).charAt(nj) != 'E') {
                                tmpSum += board.get(ni).charAt(nj) - '0';
                            }
                            if ( tmpSum > sum[ni][nj]) {
                                sum[ni][nj] = tmpSum;
                                path[ni][nj] = path[i][j];
                            } else if ( tmpSum == sum[ni][nj]) {
                                path[ni][nj] = ( path[i][j] + path[ni][nj]) % 1000000007;
                            }
                        }
                    }
                }
            }
            return new int[]{sum[0][0], path[0][0]};
        }
    }
}
