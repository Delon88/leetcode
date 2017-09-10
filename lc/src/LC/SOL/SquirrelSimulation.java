package LC.SOL;

public class SquirrelSimulation {
    class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int sum = 0, maxDiff = Integer.MIN_VALUE;
            for (int i = 0; i < nuts.length; i++) {
                int manDist = Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
                sum += 2 * manDist;
                maxDiff = Math.max(maxDiff, manDist - ( Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1])));
            }
            return sum - maxDiff;
        }
    }
}
