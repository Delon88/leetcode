package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ShortestDistancetoTargetColor {
    class Solution {
        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
            TreeSet<Integer>[] ts = new TreeSet[3];
            for (int i = 0; i < 3; i++) ts[i] = new TreeSet<>();
            for (int i = 0; i < colors.length; i++) ts[colors[i] - 1].add(i);
            List<Integer> ret = new ArrayList<>();
            for (int[] q : queries) {
                int c = q[1], i = q[0];
                if (ts[c - 1].isEmpty()) {ret.add(-1);continue;}
                Integer fl = ts[c - 1].floor(i), ceil = ts[c - 1].ceiling(i);
                if (fl == null) ret.add(ceil - i);
                else if (ceil == null) ret.add(i - fl);
                else ret.add(Math.min(i - fl, ceil - i));
            }
            return ret;
        }
    }
}
