package LC.SOL;

public class RobotBoundedInCircle {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0 , y = 0, d = 0;
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if ( c == 'L' ) d = ( d + 3 ) % 4;
                else if ( c == 'R') d = ( d + 1) % 4;
                else {
                    x += dirs[d][0]; y+= dirs[d][1];
                }
            }
            return x == 0 && y == 0 || d > 0;
        }
    }
}
