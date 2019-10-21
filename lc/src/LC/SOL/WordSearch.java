package LC.SOL;

public class WordSearch {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1,0}, {0,-1}};
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            boolean[][] v = new boolean[m][n];
            for ( int i = 0 ; i < m ; i++ ) {
                for ( int j = 0 ;j < n ; j++){
                    if ( dfs(board, v, word.toCharArray(), i , j , 0)) return true;
                }
            }
            return false;
        }

        boolean dfs(char[][] board, boolean[][] v, char[] word, int x, int y, int level ) {
            if ( level == word.length) return true;
            if ( x < 0 || y < 0 || x >= board.length || y >= board[0].length || v[x][y] || board[x][y] != word[level] ) return false;
            v[x][y] = true;
            for ( int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                if ( dfs(board, v, word, nextX , nextY, level + 1)) {
                    return true;
                }
            }
            v[x][y] = false;
            return false;
        }
    }
}
