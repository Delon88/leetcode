package LC.SOL;


public class SplitConcatenatedStrings {
    class Solution {
        public String splitLoopedString(String[] strs) {
            for (int i = 0; i < strs.length; i++) {
                String rev = new StringBuffer(strs[i]).reverse().toString();
                if (strs[i].compareTo(rev) < 0) {
                    strs[i] = rev;
                }
            }

        }
    }
}
