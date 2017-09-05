package LC.SOL;

public class ReverseWordsinaStringIII {
    class Solution {
        public String reverseWords(String s) {
            StringBuilder ret = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    ret.append(b.reverse()).append(' ');
                    b.setLength(0);
                } else {
                    b.append(s.charAt(i));
                }
            }
            if (b.length() > 0) {
                ret.append(b.reverse());
            }
            return ret.toString();
        }
    }
}
