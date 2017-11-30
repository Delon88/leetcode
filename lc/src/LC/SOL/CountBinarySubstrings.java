package LC.SOL;

public class CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            int zeroes = 0, ones = 0;
            int i = 0;
            int ret = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == '0') {
                    int count = 0;
                    while (i < s.length() && s.charAt(i) == '0') {count++;i++;}
                    zeroes = count;
                    ret += Math.min(ones, zeroes);
                } else {
                    int count = 0;
                    while (i < s.length() && s.charAt(i) == '1') {count++;i++;}
                    ones = count;
                    ret += Math.min(ones, zeroes);
                }
            }
            return ret;
        }
    }
}
