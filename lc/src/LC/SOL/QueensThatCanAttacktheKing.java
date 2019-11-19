package LC.SOL;

import java.util.*;

public class QueensThatCanAttacktheKing {
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            boolean[] isVisitedArr = new boolean[8];
            boolean[][] table = new boolean[8][8];
            for (int i = 0; i < queens.length; i++) {
                table[queens[i][0]][queens[i][1]] = true;
            }
            List<List<Integer>> list = new LinkedList<>();
            for (int i = king[0], j = king[1], count = 1; count < 8; count++) {
                for (int k = 0; k < dir.length; k++) {
                    int m = i + dir[k][0] * count;
                    int n = j + dir[k][1] * count;
                    if (m >= 0 && m < 8 && n >= 0 && n < 8 && table[m][n] && !isVisitedArr[k]) {
                        isVisitedArr[k] = true;
                        list.add(Arrays.asList(m , n));
                    }
                }
            }
            return list;
        }
    }
}
