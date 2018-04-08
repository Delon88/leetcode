package LC.SOL;

import java.util.List;

public class ConvexPolygon {
    public class Solution {
        public boolean isConvex(List<List<Integer>> points) {

            boolean hasRight = false;
            boolean hasLeft = false;
            for (int i = 0; i < points.size(); i++) {
                List<Integer> p = points.get(i);
                List<Integer> p1 = points.get((i + 1) % points.size());
                List<Integer> p2 = points.get((i + 2) % points.size());
                int cp = crossProduct(p, p1, p2);
                if (cp > 0) {
                    hasLeft = true;
                } else if (cp < 0) {
                    hasRight = true;
                }
                if (hasLeft && hasRight) return false;
            }
            return true;
        }

        int crossProduct(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
            return (p1.get(0) - p2.get(0)) * (p3.get(1) - p2.get(1)) - (p3.get(0) - p2.get(0)) * (p1.get(1) - p2.get(1));
        }
    }
}
