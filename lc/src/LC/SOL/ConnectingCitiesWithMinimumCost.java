package LC.SOL;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    class Solution {

        int[] id;
        int n;

        public int minimumCost(int N, int[][] connections) {
            n = N;
            id = new int[n + 1];
            for (int i = 0; i < n; i++) id[i] = i;
            Arrays.sort(connections, (c1, c2) -> c1[2] - c2[2]);

            int ret = 0;
            for (int[] c : connections) {
                int r1 = find(c[0]), r2 = find(c[1]);
                if (r1 != r2) {
                    ret += c[2];
                    id[r1] = r2;
                    n--;
                }
            }
            return n == 1 ? ret : -1;

        }

        int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
