package LC.SOL;

public class CountandSay {
    class Solution {
        public String countAndSay(int n) {
            String ret = "1";
            for (int i = 2; i <= n; i++) {
                StringBuilder b = new StringBuilder();
                for (int j = 0; j < ret.length(); ) {
                    char c = ret.charAt(j);
                    int count = 0;
                    while ( j < ret.length() && c == ret.charAt(j)) {
                        j++;
                        count++;
                    }
                    b.append(count).append(c);
                }
                ret = b.toString();
            }
            return ret;
        }
    }
}
