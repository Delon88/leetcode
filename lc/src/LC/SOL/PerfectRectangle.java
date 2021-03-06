package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
    public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            if (rectangles == null || rectangles.length == 0) return false;
            int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE;
            int y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
            Set<String> set = new HashSet<>();
            int area = 0;
            for (int[] r : rectangles) {
                x1 = Math.min(x1, r[0]);
                y1 = Math.min(y1, r[1]);
                x2 = Math.max(x2, r[2]);
                y2 = Math.max(y2, r[3]);
                area += (r[3] - r[1]) * (r[2] - r[0]);
                String s1 = r[0] + "," + r[1];
                String s2 = r[0] + "," + r[3];
                String s3 = r[2] + "," + r[1];
                String s4 = r[2] + "," + r[3];
                if (!set.add(s1)) set.remove(s1);
                if (!set.add(s2)) set.remove(s2);
                if (!set.add(s3)) set.remove(s3);
                if (!set.add(s4)) set.remove(s4);
            }
            if (set.size() != 4 || !set.contains(x1 + "," + y1) || !set.contains(x1 + "," + y2) || !set.contains(x2 + "," + y1)
                    || !set.contains(x2 + "," + y2)) return false;
            return area == (y2 - y1) * (x2 - x1);
        }
    }
}
