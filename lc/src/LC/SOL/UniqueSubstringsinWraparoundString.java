package LC.SOL;

public class UniqueSubstringsinWraparoundString {
    public class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] count = new int[26];


            int maxCount = 0;
            for (int i = 0; i < p.length(); i++) {
                // check if continuous
                if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                    maxCount++;
                } else {
                    maxCount = 1;
                }
                count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxCount);
            }

            int ret = 0;
            for (int c : count) {
                ret += c;
            }

            return ret;
        }
    }
}
