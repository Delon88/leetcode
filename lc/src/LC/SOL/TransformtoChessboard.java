package LC.SOL;

public class TransformtoChessboard {
    class Solution {

        public int movesToChessboard(int[][] board) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((board[0][0] ^ board[i][0]) != (board[0][j] ^ board[i][j])) return -1;
                }
            }
            int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
            for (int i = 0; i < n; i++) {
                rowSum += board[0][i];
                colSum += board[i][0];
                rowSwap += board[i][0] == (i % 2) ? 0 : 1;
                colSwap += board[0][i] == (i % 2) ? 0 : 1;
            }
            if (n / 2 > rowSum || rowSum > (n + 1) / 2) return -1;
            if (n / 2 > colSum || colSum > (n + 1) / 2) return -1;
            if (n % 2 == 0) {
                rowSwap = Math.min(rowSwap, n - rowSwap);
                colSwap = Math.min(colSwap, n - colSwap);
            } else {
                if (rowSwap % 2 == 1) rowSwap = n - rowSwap;
                if (colSwap % 2 == 1) colSwap = n - colSwap;
            }
            return (rowSwap + colSwap) / 2;
        }
    }
}
