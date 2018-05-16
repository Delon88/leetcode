package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
    class Solution {

        int[][] dirs = {{1, 0 }, {0, 1} , {-1, 0} , {0 , -1}};
        public void wallsAndGates(int[][] rooms) {
            if ( rooms == null || rooms.length == 0 ) return;
            Queue<int[]> q = new LinkedList<>();
            int m = rooms.length, n = rooms[0].length;
            for ( int i = 0 ; i < m ; i++) {
                for ( int j = 0 ;  j < n ; j++) {
                    if ( rooms[i][j] == 0) {q.offer(new int[]{i,j});}
                }
            }

            while ( !q.isEmpty()) {
                int[] node = q.poll();
                int x = node[0], y = node[1];
                for ( int[] d : dirs) {
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if ( nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && rooms[nextX][nextY] == Integer.MAX_VALUE) {
                        rooms[nextX][nextY] = rooms[x][y] + 1;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
