package LC.SOL;

public class NumberofSegmentsinaString {
    class Solution {
        public int countSegments(String s) {
            int count = 0, i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != ' ') {
                    while (i < s.length() && s.charAt(i) != ' ') {
                        i++;
                    }
                    count++;
                } else {
                    i++;
                }
            }
            return count;
        }
    }
}
