package LC.SOL;

public class RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            int minCharIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < s.charAt(minCharIndex)) {
                    minCharIndex = i;
                }
                if (--count[s.charAt(i) - 'a'] == 0) break;
            }
            if (s.length() == 0) {
                return "";
            } else {
                return s.charAt(minCharIndex) + removeDuplicateLetters(
                        s.substring(minCharIndex + 1).replaceAll(s.charAt(minCharIndex) + "", ""));
            }
        }
    }
}
