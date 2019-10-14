package LC.SOL;

public class GetEqualSubstringsWithinBudget {
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int i = 0, j = 0;
            int cost = 0, len = 0;
            for (; j < s.length(); j++) {
                cost += Math.abs(s.charAt(j) - t.charAt(j));
                while (cost > maxCost) {
                    cost -= Math.abs(s.charAt(i) - t.charAt(i)); i++;
                }
                len = Math.max(len, j - i + 1);
            }
            return len;
        }
    }
}
