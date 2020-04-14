package LC.SOL;

public class DecryptStringfromAlphabettoIntegerMapping {
    class Solution {
        public String freqAlphabets(String s) {
            String ret = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '#') {ret = (char) (Integer.parseInt(s.substring(i - 2, i)) - 1 + 'a') + ret; i -= 2;}
                else ret = ((char) (c - '0' - 1 + 'a')) + ret;
            }
            return ret;
        }
    }
}
