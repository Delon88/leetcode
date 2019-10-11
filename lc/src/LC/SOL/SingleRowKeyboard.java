package LC.SOL;

public class SingleRowKeyboard {
    class Solution {
        public int calculateTime(String keyboard, String word) {
            int[] id = new int[26];
            for (int i = 0; i < 26; i++) {
                id[keyboard.charAt(i) - 'a'] = i;
            }
            int ret = 0, i = 0;
            for (char c : word.toCharArray()) {
                ret += Math.abs(i - id[c - 'a']);
                i = id[c - 'a'];
            }
            return ret;
        }
    }
}
