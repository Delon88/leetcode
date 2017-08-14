package LC.SOL;

public class LonelyPixelI {
    public class Solution {

        public int findLonelyPixel(char[][] picture) {
            int[] row = new int[picture.length];
            int[] col = new int[picture[0].length];
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (picture[i][j] == 'B') {
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) count++;
                }
            }
            return count;
        }
    }
}
