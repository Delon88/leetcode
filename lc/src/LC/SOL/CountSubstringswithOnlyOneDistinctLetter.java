package LC.SOL;

public class CountSubstringswithOnlyOneDistinctLetter {
    class Solution {
        public int countLetters(String S) {
            int ret = 0 ;
            for ( int i = 0 ;i < S.length(); ) {
                char c = S.charAt(i);
                int count = 0;
                while ( i < S.length() && c == S.charAt(i)) {
                    i++; count++; ret += count;
                }
            }
            return ret;
        }
    }
}
