package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErecttheFence {
    static class Solution {
        public List<Point> outerTrees(Point[] points) {
            Set<Point> set = new HashSet<>();
            Point leftMost = points[0];
            for (Point p : points) {
                if (p.x < leftMost.x) {
                    leftMost = p;
                }
            }
            set.add(leftMost);
            Point cur = leftMost;
            do {
                Point nextPoint = points[0];
                for (Point p : points) {
                    if (p == cur) continue;
                    int cross = crossProduct(cur, nextPoint, p);
                    if (cross > 0 || cur == nextPoint || (cross == 0 && distance(cur, p) > distance(nextPoint, p))) {
                        nextPoint = p;
                    }
                }
                for (Point p : points) {
                    if (p == cur) continue;
                    int cross = crossProduct(cur, nextPoint, p);
                    if (cross == 0) set.add(p);
                }
                cur = nextPoint;
            } while (cur != leftMost);
            return new ArrayList<>(set);
        }

        private int crossProduct(Point A, Point B, Point C) {
            return ((A.x - B.x) * (C.y - B.y) - (C.x - B.x) * (A.y - B.y));
        }

        private int distance(Point p1, Point p2) {
            return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        }

        class Point {
            int x;
            int y;

            Point() {
                x = 0;
                y = 0;
            }

            Point(int a, int b) {
                x = a;
                y = b;
            }
        }
    }

    public static void main(String[] args) {
        String exMsg = "com.amazon.servicecontainer=[ccom.amazon.middleware]";
        String processName = "dummpy";
        if ( exMsg != null && exMsg.startsWith("com.amazon.servicecontainer")) {
            // get real package name for this crash
            int leftBoundary = exMsg.indexOf("[", "com.amazon.servicecontainer".length() + 1);
            int rightBoundary = exMsg.indexOf("]", leftBoundary + 1);
            if (leftBoundary != -1 && rightBoundary != -1) {
                processName = exMsg.substring(leftBoundary + 1, rightBoundary);
            }
        }
        System.out.println(processName);


    }
}
