package LC.SOL;

public class CellswithOddValuesinaMatrix {
    class Solution {
        public int oddCells(int n, int m, int[][] indices) {
            int[] row = new int[n];
            int[] col = new int[m];
            for (int[] in : indices) {
                row[in[0]]++;
                col[in[1]]++;
            }
            int odd = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (((row[i] + col[j]) & 1) == 1) odd++;
                }
            }
            return odd;
        }
    }
}
