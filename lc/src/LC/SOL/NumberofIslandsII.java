package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> ret = new ArrayList<>();
            if (m <= 0 || n <= 0) return ret;
            int count = 0;                      // number of islands
            int[] id = new int[m * n];       // one island = one tree
            Arrays.fill(id, -1);
            for (int[] p : positions) {
                int root = n * p[0] + p[1];     // assume new point is isolated island
                if (id[root] == -1) {
                    id[root] = root;             // add new island
                    count++;
                    for (int[] dir : dirs) {
                        int x = p[0] + dir[0];
                        int y = p[1] + dir[1];
                        int nb = n * x + y;
                        if (x < 0 || x >= m || y < 0 || y >= n || id[nb] == -1) continue;

                        int rootNb = root(id, nb);
                        if (root != rootNb) {
                            id[rootNb] = root;
                            count--;
                        }
                    }
                }

                ret.add(count);
            }
            return ret;
        }

        public int root(int[] id, int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];   // only one line added
                i = id[i];
            }
            return i;
        }
    }

}
