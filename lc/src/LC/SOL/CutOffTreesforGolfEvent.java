package LC.SOL;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesforGolfEvent {
    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            for (int i = 0; i < forest.size(); i++) {
                for (int j = 0; j < forest.get(0).size(); j++) {
                    int height = forest.get(i).get(j);
                    if (height != 0) {
                        q.add(new int[]{i, j, height});
                    }
                }
            }
            int[] start = {0, 0};
            int ret = 0;
            while (!q.isEmpty()) {
                int[] end = q.poll();
                int dist = dist(forest, start, end);
                if ( dist == -1) return -1;
                ret += dist;
                start = end;
            }
            return ret;
        }

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int dist(List<List<Integer>> forest, int[] start, int[] end) {
            int m = forest.size(), n = forest.get(0).size();
            boolean[][] v = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();
            q.offer(start);
            int dist = 0;
            v[start[0]][start[1]] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] node = q.poll();
                    if (node[0] == end[0] && node[1] == end[1]) return dist;
                    for (int[] d : dirs) {
                        int nextX = node[0] + d[0];
                        int nextY = node[1] + d[1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && forest.get(nextX).get(nextY) != 0 &&
                                !v[nextX][nextY]) {
                            q.offer(new int[]{nextX, nextY, forest.get(nextX).get(nextY)});
                            v[nextX][nextY] = true;
                        }
                    }
                }
                dist++;
            }

            return -1;
        }
    }
}
