package LC.SOL;

public class MinimumSwapstoMakeStringsEqual {
    class Solution {
        public int minimumSwap(String s1, String s2) {
            if (s1.length() != s2.length()) return -1;
            int[] c1 = count(s1), c2 = count(s2);
            int swap = 0;
            for ( int i = 0 ; i < 26 ; i++) {
                if ( (c1[i] + c2[i]) % 2 != 0 ) return -1;
                else swap += Math.abs(c1[])
            }
        }

        int[] count(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;
            return count;
        }
    }
}
