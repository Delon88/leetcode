package LC.SOL;

public class FindSmallestCommonElementinAllRows {
    class Solution {
        public int smallestCommonElement(int[][] mat) {
            int[] count = new int[10001];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if ( ++count[mat[i][j]] == mat.length ) return mat[i][j];
                }
            }
            return -1;
        }
    }
}
