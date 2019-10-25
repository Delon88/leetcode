package LC.SOL;

public class OneEditDistance {
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (s.length() > t.length()) return isOneEditDistance(t, s);
            if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
            int i = 0, j = 0;
            while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            if (s.length() != t.length()) {
                j++;
            } else {
                i++;
                j++;
            }
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) return false;
                i++;
                j++;
            }
            return true;
        }
    }

    class Solution1 {
        public boolean isOneEditDistance(String s, String t) {
            if (Math.abs(s.length() - t.length()) > 1) return false;
            if (s.length() == t.length()) return isOneReplace(s, t);
            if (s.length() > t.length()) return isOneDel(t, s);
            return isOneDel(s, t);
        }

        private boolean isOneReplace(String s, String t) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }
            return count == 1;
        }

        private boolean isOneDel(String s, String t) {
            for (int i = 0, j = 0; i < s.length() && j < s.length(); i++, j++) {
                if (s.charAt(i) != t.charAt(i)) return s.substring(i).equals(t.substring(i + 1));
            }
            return true;
        }
    }
}
