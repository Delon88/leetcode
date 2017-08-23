package LC.SOL;

public class ReverseStringII {
    class Solution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int start = 0;
            boolean reverse = true;
            while (start < s.length()) {
                int end = start + k - 1;
                if (end > s.length() - 1) {
                    end = s.length() - 1;
                }
                if (reverse) {
                    reverse(arr, start, end);
                    reverse = false;
                } else {
                    reverse = true;
                }
                start += k;
            }
            return new String(arr);
        }

        void reverse(char[] s, int start, int end) {
            while (start < end) {
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
