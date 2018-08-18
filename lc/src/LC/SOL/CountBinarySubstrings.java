package LC.SOL;

public class CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            int ret = 0, curLen = 1, prevLen = 0;
            for ( int i = 1 ; i  < s.length() ; i++) {
                if ( s.charAt(i) == s.charAt(i - 1)) { curLen++;}
                else {
                    prevLen = curLen;
                    curLen = 1;
                }
                if ( prevLen >= curLen ) ret++;
            }
            return ret;
        }
    }
}
