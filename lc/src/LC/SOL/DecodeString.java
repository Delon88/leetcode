package LC.SOL;


public class DecodeString {
    public class Solution {
        public String decodeString(String s) {
            int[] i = {0};
            return decode(s, i);
        }

        private String decode(String s, int[] i) {
            StringBuilder res = new StringBuilder();
            while (i[0] < s.length() && s.charAt(i[0]) != ']') {
                if (Character.isDigit(s.charAt(i[0]))) {
                    int n = 0;
                    while ( i[0] < s.length() && Character.isDigit(s.charAt(i[0]))) {
                        n = n * 10 + ( s.charAt(i[0]) - '0');
                        i[0]++;
                    }
                    // skip [
                    i[0]++;
                    String repeat = decode(s, i );
                    // skip ]
                    i[0]++;
                    while ( n-- > 0 ) {
                        res.append(repeat);
                    }
                } else {
                    res.append(s.charAt(i[0]++));
                }
            }
            return res.toString();
        }
    }
}
