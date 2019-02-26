package LC.SOL;

public class ProjectionAreaof3DShapes {
    class Solution {
        public int projectionArea(int[][] grid) {
            int ret = 0,  n = grid.length;
            int x  = 0, y = 0 , z = 0;
            for ( int i = 0 ; i < grid.length ; i++) {
                int tx = 0 , ty = 0;
                for ( int j = 0 ; j < grid[0].length ; j++) {
                    tx = Math.max( tx , grid[j][i]);
                    ty = Math.max( ty , grid[i][j]);
                    if ( grid[i][j] > 0 )  z++;
                }
                x += tx ; y += ty;
            }
            return x + y + z;
        }
    }
}
