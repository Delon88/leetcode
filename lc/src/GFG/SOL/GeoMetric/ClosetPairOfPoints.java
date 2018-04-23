package GFG.SOL.GeoMetric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosetPairOfPoints {


    public double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) - (p1.y - p2.y) * (p1.y - p2.y));
    }

    public Pair bruteForce(List<Point> points) {
        int n = points.size();
        if ( n < 2) return null;
        Pair minP = new Pair(points.get(0) , points.get(1));
        for ( int i = 0 ; i < points.size() ; i++) {
            for ( int j = i + 1 ; j < points.size() ; j++) {
                Pair p = new Pair(points.get(i), points.get(j));
                if ( p.dist < minP.dist) {
                    minP = p;
                }
            }
        }
        return minP;
    }

    void merge(Point[] y, Point[] aux, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = y[i];
        }
        // merge back to Y
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) y[k] = aux[j++];
            else if (j > end) y[k] = aux[i++];
            else if (aux[i] < aux[j]) aux[]
        }
    }

    public Pair closetPairHelper(List<Point> x, List<Point> y) {
        if ( x.size() <=  3) return bruteForce(x );
        int mid = x.size() / 2;

        List<Point> leftOfCenter = x.subList(0 , mid + 1);
        List<Point> rightOfCenter = x.subList(mid + 1 , x.size());

        List<Point> temp = new ArrayList<>(leftOfCenter);


    }

    public int closetPair(List<Point> points) {
        int n = points.size();
        List<Point> x = points;
        List<Point> y = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            y.add(x.get(i));
        }
        Collections.sort(x, (p1, p2) -> { if ( p1.x < p2.x) return -1; else if ( p1.x == p2.x) return 0; else return 1; });
        Collections.sort(y, (p1, p2) -> { if ( p1.y < p2.y) return -1; else if ( p1.y == p2.y) return 0; else return 1;} );
        for (int i = 0; i < n - 1; i++) {
            if (x.get(i).x == x.get(i + 1).x && x.get(i).y == x.get(i + 1).y) {
                return 0;
            }
        }
        closetPairHelper(x, y);
    }

    public class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Pair {
        Point p1;
        Point p2;
        double dist;
        public Pair(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = Math.sqrt(( p1.x - p2.x) * (p1.x - p2.x) - ( p1.y - p2.y) * ( p1.y - p2.y));
        }
     }

    public static void main(String[] args) {

    }

}
