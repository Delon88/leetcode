package LC.SOL;


import java.util.ArrayList;
import java.util.List;

public class SwapAdjacentinLRString {
    class Solution {
        public boolean canTransform(String start, String end) {
            if (start.length() != end.length()) return false;

            List<int[]> s = new ArrayList<>();
            List<int[]> e = new ArrayList<>();
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) == 'L' || start.charAt(i) == 'R') {
                    s.add(new int[]{start.charAt(i), i});
                }
                if (end.charAt(i) == 'L' || end.charAt(i) == 'R') {
                    e.add(new int[]{end.charAt(i), i});
                }
            }

            if (s.size() != e.size()) return false;
            for (int i = 0; i < s.size(); i++) {
                int[] si = s.get(i);
                int[] ei = e.get(i);
                if (si[0] != ei[0]) return false;
                if (si[0] == 'L') {
                    if (si[1] < ei[1]) return false;
                } else if (si[0] == 'R') {
                    if (si[1] > ei[1]) return false;
                }
            }
            return true;
        }
    }
}
