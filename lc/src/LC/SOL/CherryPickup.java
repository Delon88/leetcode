package LC.SOL;

import java.util.Arrays;

public class CherryPickup {
    class Solution {
        int N;

        int[][] grid;

        int[][][] dp;

        public int cherryPickup(int[][] grid) {
            N = grid.length;
            dp = new int[N][N][N];
            this.grid = grid;
            for (int[][] layer : dp) {
                for (int[] l : layer) {
                    Arrays.fill(l, Integer.MIN_VALUE);
                }
            }
            return Math.max(0, solve(0, 0, 0));
        }

        int solve(int r1, int c1, int c2) {
            int r2 = r1 + c1 - c2;
            if (r1 == N || c1 == N || r2 == N || c2 == N || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                return -999999;
            }
            if (r1 == N - 1 && c1 == N - 1) {
                return grid[r1][c1];
            }
            if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
                return dp[r1][c1][c2];
            }
            int ret = grid[r1][c1];
            if ( r1 != r2 ) { ret += grid[r2][c2];}
            ret += Math.max(Math.max(solve(r1 + 1,c1,c2) , solve(r1,c1 + 1,c2)), Math.max(solve(r1 + 1,c1,c2 + 1) , solve(r1,c1 + 1,c2 + 1)));
            dp[r1][c1][c2] = ret;
            return ret;
        }
    }
}
