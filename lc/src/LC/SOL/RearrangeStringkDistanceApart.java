package LC.SOL;

public class RearrangeStringkDistanceApart {
    class Solution {
        public String rearrangeString(String s, int k) {
            int len = s.length();
            int[] count = new int[26];
            int[] valid = new int[26];
            for ( int i = 0 ; i < len ; i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder b = new StringBuilder();
            for ( int i = 0 ; i < len ;i++) {
                int cand = findNextChar(count, valid, i);
                if ( cand == -1 ) return "";
                count[cand]--;
                valid[cand] = i + k;
                b.append((char) ( cand + 'a'));
            }
            return b.toString();
        }

        int findNextChar(int[] count, int[] valid, int index) {
            int ret = -1, max = 0;
            for ( int i = 0 ; i < count.length; i++) {
                if ( count[i] > max && valid[i] <= index ) {
                    ret = i;
                    max = count[i];
                }
            }
            return ret;
        }
    }
}
