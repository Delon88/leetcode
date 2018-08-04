package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ErecttheFence {
    static class Solution {
        public List<Point> outerTrees(Point[] points) {
            Set<Point> set = new HashSet<>();
            Point first = points[0];
            for ( int i = 1 ; i < points.length ; i++) {
                if ( points[i].x < first.x) {
                    first = points[i];
                }
            }
            Point cur = first;
            set.add(first);
            do {
                Point nextPoint = points[0];
                for ( Point p : points) {
                    if ( p == cur ) continue;
                    int cross = crossProduct(nextPoint, cur, p );
                    if ( cross > 0  || (cross == 0  && dist(cur, nextPoint) < dist(cur , p) )) {
                        nextPoint = p;
                    }
                }
                // add all colinear points
                for ( Point p : points) {
                    if ( p == cur ) continue;
                    if ( crossProduct(nextPoint, cur, p) == 0) set.add(p);
                }
                cur = nextPoint;
            } while ( cur != first );
            return new ArrayList<>(set);
        }

        int crossProduct(Point p1, Point p2, Point p3 ) {
            return (p1.x - p2.x) * ( p3.y - p2.y) - ( p3.x - p2.x) * ( p1.y - p2.y);
        }

        int dist(Point p1, Point p2) {
            return ( p1.x - p2.x) * ( p1.x - p2.x)  + ( p1.y - p2.y) * ( p1.y - p2.y);
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
