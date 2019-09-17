package LC.SOL;

public class NumberofEnclaves {
    class Solution {
        int reach;
        public int numEnclaves(int[][] A) {
            int m = A.length, n = A[0].length;
            boolean[][] v = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    if (A[i][j] == 1) count++;
                }
            reach = 0;
            for (int i = 0; i < m; i++) {
                dfs(A, v , i , 0 );dfs(A , v , i , n - 1);
            }
            for (int i = 0; i < n; i++) {
                dfs(A, v , 0  , i); dfs(A , v , m -1, i);
            }
            return count - reach;
        }

        void dfs(int[][] A, boolean[][] v, int x, int y) {
            if ( x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] != 1 || v[x][y] ) return;
            v[x][y] = true;
            reach++;
            dfs(A , v , x + 1 , y); dfs(A , v , x , y + 1); dfs(A , v , x - 1 , y);dfs(A , v , x , y - 1);
        }
    }
}
