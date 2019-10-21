package LC.contest;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.*;

public class Contest {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) return true;
        double k = slop(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length; i++) {
            if (k != slop(coordinates[i], coordinates[i - 1])) return false;
        }
        return true;
    }

    double slop(int[] c1, int[] c2) {
        double s = c1[0] - c2[0] == 0 ? Double.POSITIVE_INFINITY : (double) (c1[1] - c2[1]) / (c1[0] - c2[0]);
        return s;
    }

    Set<String> set;

    public List<String> removeSubfolders(String[] folder) {
        set = new HashSet<>();
        for (String f : folder) set.add(f);
        List<String> ret = new ArrayList<>();
        for (String f : folder) {
            String[] cols = f.split("/");
            String prefix = "";
            boolean remove = false;
            for (int i = 1; i < cols.length - 1; i++) {
                prefix = prefix + "/" + cols[i];
                if (set.contains(prefix)) remove = true;
            }
            if (!remove) ret.add(f);
        }
        return ret;
    }


    int  n;
    public int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0); map.put('W', 0);map.put('E', 0);map.put('R', 0);
        for (Character c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int l = 0, r = 0, min = s.length();
        n = s.length();
        while (r < n ) {
            char rc = s.charAt(r++);
            map.put(rc, map.get(rc) -1);
            while( isBal(map)) {
                min = Math.min(min, r - l);
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) + 1);
            }
        }
        return min;
    }

    private boolean isBal(Map<Character, Integer> map) {
        for (Integer i : map.values())
            if (i > n / 4) return false;
        return true;
    }


    class Solution1 {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int[][] jobs = new int[startTime.length][3];
            int n = startTime.length;
            for (int i = 0; i < n; i++) {
                jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            Arrays.sort(jobs, (j1, j2) -> j1[1] - j2[1]);
            int[] dp = new int[n];
            dp[0] = jobs[0][2];
            for (int i = 1; i < n; i++) {
                int curProfit = jobs[i][2];
                int last = lastNonConflictProfit(jobs, i);
                if (last != -1) curProfit += dp[last];
                dp[i] = Math.max(curProfit, dp[i - 1]);
            }
            return dp[n - 1];
        }

        int lastNonConflictProfit(int[][] jobs, int i) {
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) return j;
            }
            return -1;
        }

        int maxprofit(int[] jobs) {

        }
    }
}
