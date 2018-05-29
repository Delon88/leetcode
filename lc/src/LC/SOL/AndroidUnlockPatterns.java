package LC.SOL;

public class AndroidUnlockPatterns {
    class Solution {
        public int numberOfPatterns(int m, int n) {
            int[][] skip = new int[10][10];
            skip[1][3] = skip[3][1] = 2;
            skip[1][7] = skip[7][1] = 4;
            skip[7][9] = skip[9][7] = 8;
            skip[9][3] = skip[3][9] = 6;
            skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
            boolean[] v = new boolean[10];
            int ret = 0;
            for (int i = m; i <= n; i++) {
                ret += dfs(v, skip, 1, i - 1) * 4;
                ret += dfs(v, skip, 2, i - 1) * 4;
                ret += dfs(v, skip, 5, i - 1);
            }
            return ret;
        }

        int dfs(boolean[] v, int[][] skip, int cur, int remaining) {
            if (remaining < 0) return 0;
            if (remaining == 0) return 1;
            v[cur] = true;
            int ret = 0;
            for (int i = 1; i <= 9; i++) {
                if (!v[i] && (skip[cur][i] == 0 || v[skip[cur][i]])) {
                    ret += dfs(v, skip, i, remaining - 1);
                }
            }
            v[cur] = false;
            return ret;
        }
    }
}
