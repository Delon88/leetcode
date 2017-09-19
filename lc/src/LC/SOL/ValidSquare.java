package LC.SOL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            Set<Integer> set = new HashSet<>(Arrays.asList(dist(p1, p2), dist(p1, p3), dist(p1, p4), dist(p2, p3), dist(p2, p4), dist(p3, p4)));
            return !set.contains(0) && set.size() == 2;
        }


        int dist(int[] p1, int[] p2) {
            return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        }
    }
}
