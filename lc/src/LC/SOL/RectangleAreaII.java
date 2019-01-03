package LC.SOL;

import java.util.*;

public class RectangleAreaII {
    class Solution {
        class Point {
            int x;
            int y;
            int val;

            public Point(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }

        public int rectangleArea(int[][] rectangles) {
            List<Point> points = new ArrayList<>();
            int M = 1000000007;
            for (int[] r : rectangles) {
                points.add(new Point(r[0], r[1], 1));
                points.add(new Point(r[0], r[3], -1));
                points.add(new Point(r[2], r[3], 1));
                points.add(new Point(r[2], r[1], -1));
            }
            Collections.sort(points, (p1, p2) -> {
                if (p1.x == p2.x) {
                    return p2.y - p1.y;
                }
                return p1.x - p2.x;
            });

            TreeMap<Integer, Integer> map = new TreeMap<>();
            int preX = -1, preY = -1, ret = 0;
            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                map.put(p.y, map.getOrDefault(p.y, 0) + p.val);
                if (i == points.size() - 1 || points.get(i + 1).x > p.x) {
                    if ( preX  > -1 ) {
                        ret += ((long) preY * ( p.x - preX)) % M;
                        ret %= M;
                    }
                    preX = p.x;
                    preY = getY(map);
                }
            }
            return ret;
        }

        int getY(Map<Integer,Integer> map ) {
            int ret = 0, preY = -1, count = 0;
            for ( Map.Entry<Integer,Integer> e : map.entrySet()) {
                if ( preY >= 0 &&  count > 0 ) {
                    ret += e.getKey() - preY;
                }
                count += e.getValue();
                preY = e.getKey();
            }
            return ret;
        }
    }
}
