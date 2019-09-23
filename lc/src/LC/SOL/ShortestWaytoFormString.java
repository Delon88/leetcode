package LC.SOL;

public class ShortestWaytoFormString {
    class Solution {
        public int shortestWay(String source, String target) {
            int j = 0, ret = 0;
            while ( j < target.length()) {
                int oriJ = j;
                for ( int i = 0 ; i < source.length() ; i++) {
                    if ( j < target.length() && target.charAt(j) == source.charAt(i)) j++;
                }
                if ( oriJ == j && j != target.length()) return -1;
                ret++;
            }
            return ret;
        }
    }
}
