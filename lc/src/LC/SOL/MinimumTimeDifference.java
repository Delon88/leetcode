package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MinimumTimeDifference {
    class Solution {

        int HOUR_24 = 24 * 60;

        public int findMinDifference(List<String> timePoints) {
            TreeSet<Integer> set = new TreeSet<>();
            for (String t : timePoints) {
                if (!set.add(getTime(t))) return 0;
            }
            int min = diff(set.first(), set.last());
            List<Integer> list = new ArrayList<>(set);
            for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(diff(list.get(i), list.get(i + 1)), min);
            }
            return min;
        }

        int getTime(String t) {
            String[] a = t.split(":");
            return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        }

        int diff(int t1, int t2) {
            if (t1 > t2) {
                diff(t2, t1);
            }
            return Math.min(t2 - t1, t1 + HOUR_24 - t2);
        }
    }
}
