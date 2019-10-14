package LC.SOL;

public class MaximumNumberofBalloons {
    class Solution {
        public int maxNumberOfBalloons(String text) {
            String ba = "balloon";
            int[] tCn = count(text);
            int[] baCn = count(ba);
            int ret = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (baCn[i] == 0 ) continue;
                ret = Math.min(ret, tCn[i] / baCn[i]);
            }
            return ret == Integer.MAX_VALUE ? 0 : ret;
        }

        int[] count(String s) {
            int[] cn = new int[26];
            for (char c : s.toCharArray()) {
                cn[c - 'a']++;
            }
            return cn;
        }
    }
}
