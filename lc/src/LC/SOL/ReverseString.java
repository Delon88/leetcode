package LC.SOL;

public class ReverseString {
    class Solution {
        public String reverseString(String s) {
            char[] a = s.toCharArray();
            for ( int start = 0 , end = s.length() - 1; start < end ; start++, end--) {
                char tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }
            return new String(a);
        }
    }
}
