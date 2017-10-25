package LC.SOL;

public class PalindromicSubstrings {
    class Solution {
        int count = 0;

        public int countSubstrings(String s) {
            count = 0;
            if (s == null || s.length() == 0) return count;
            for (int i = 0; i < s.length(); i++) {
                getPal(i, i, s);
                getPal(i, i + 1, s);
            }
            return count;
        }

        void getPal(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
    }
}
