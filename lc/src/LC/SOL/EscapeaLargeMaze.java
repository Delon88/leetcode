package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class EscapeaLargeMaze {
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int limit = (int)1e6;

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            Set<String> set = new HashSet<>();
            for ( int[] b : blocked) set.add(b[0] + "," + b[1]);
            return bfs(set, source, target) && bfs(set, target, source);
        }

        boolean bfs(Set<String> blocked, int[] source, int[] target) {
            Set<String> seen = new HashSet<>();
            seen.add(source[0] + "," + source[1]);
            Queue<int[]> q = new LinkedList<>();
            q.offer(source);
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for ( int[] d : dirs) {
                    int nextX = cur[0] + d[0], nextY = cur[1] + d[1];
                    if ( nextX >= 0 && nextX < limit && nextY >= 0 && nextY < limit) {
                        String key = nextX + "," + nextY;
                        if ( seen.contains(key) || blocked.contains(key)) continue;
                        if ( nextX == target[0] && nextY == target[1] ) return true;
                        seen.add(key);
                        q.offer(new int[]{nextX , nextY});
                    }
                    if ( seen.size() >= 20000) return true;
                }
            }
            return false;
        }
    }
}
