package LC.SOL;

import java.util.*;

public class MinimumMovestoReachTargetwithRotations {
    public int minimumMoves(int[][] g) {
        int n = g.length;
        int[] start = {0, 0, 0, 0}, target = {n - 1, n - 2, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        Set<String> seen = new HashSet<>();
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0], c = pos[1], dr = pos[2], steps = pos[3];        // snake tail row, column, row difference, steps.
            if (Arrays.equals(Arrays.copyOf(pos, 3), target))               // reach target.
                return steps;
            if (seen.add(r + "," + c + "," + dr)) {                         // prune duplicates.
                if (dr == 0) {                                              // horizontal position.
                    if (r + 1 < n && g[r + 1][c] + g[r + 1][c + 1] == 0)    // the two cells below are empty: down and colock-wise rotation.
                        q.addAll(Arrays.asList(new int[]{r + 1, c, 0, steps + 1}, new int[]{r, c, 1, steps + 1}));
                    if (c + 2 < n && g[r][c + 2] == 0)                      // the right cell is empty.
                        q.offer(new int[]{r, c + 1, 0, steps + 1});         // right.
                } else {                                                     // vertical position.
                    if (c + 1 < n && g[r][c + 1] + g[r + 1][c + 1] == 0)    // the two cells right are empty: right and counterclock-wise rotation.
                        q.addAll(Arrays.asList(new int[]{r, c + 1, 1, steps + 1}, new int[]{r, c, 0, steps + 1}));
                    if (r + 2 < n && g[r + 2][c] == 0)                      // the below cell is empty.
                        q.offer(new int[]{r + 1, c, 1, steps + 1});         // down.
                }
            }
        }
        return -1;
    }
}
