package LC.SOL;

public class ReverseWordsinaString {
    public class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] a = s.split("\\s+");
            StringBuilder b = new StringBuilder();
            for ( int i = a.length - 1;  i >= 0 ; i--) {
                if ( i == 0 ) {
                    b.append(a[i]);
                } else {
                    b.append(a[i]).append(" ");
                }
            }
            return b.toString();
        }
    }
}
