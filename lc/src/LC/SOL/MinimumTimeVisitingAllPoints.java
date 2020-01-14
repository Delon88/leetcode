package LC.SOL;

public class MinimumTimeVisitingAllPoints {
    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int ret = 0;
            for (int i = 1; i < points.length; i++) {
                int[] p1 = points[i], p0 = points[i - 1];
                ret += Math.max(Math.abs(p1[1] - p0[1]), Math.abs(p1[0] - p0[0]));
            }
            return ret;
        }
    }
}
