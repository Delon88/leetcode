package LC.SOL;

public class EqualRationalNumbers {
    class Solution {
        public boolean isRationalEqual(String S, String T) {
            return toDouble(S) == toDouble(T);
        }

        double toDouble(String s) {
            int index = s.indexOf('(');
            if (index != -1) {
                String base = s.substring(0, index);
                String repeat = s.substring(index + 1, s.length() - 1);
                for (int j = 0; j < 20; j++) base += repeat;
                return Double.valueOf(base);
            }
            return Double.valueOf(s);
        }
    }
}
