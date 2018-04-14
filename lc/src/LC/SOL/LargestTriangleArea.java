package LC.SOL;

public class LargestTriangleArea {
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double area = 0.0d;
            for (int[] a : points) {
                for (int[] b : points) {
                    for (int[] c : points) {
                        area = Math.max(area, 0.5 *
                                Math.abs((b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1])));
                    }
                }
            }
            return area;
        }
    }
}
