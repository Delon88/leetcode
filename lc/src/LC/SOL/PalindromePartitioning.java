package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ret = new ArrayList<>();
            if ( s == null || s.length() == 0) return ret;
            dfs( s, 0 , new ArrayList<>(), ret);
            return ret;
        }

        void dfs(String s , int start, List<String> tmp,List<List<String>> ret) {
            if ( start >= s.length()) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            for ( int i = start ; i < s.length() ; i++) {
                if ( isPal(s , start , i)) {
                    tmp.add(s.substring(start, i + 1));
                    dfs(s, i + 1 , tmp, ret);
                    tmp.remove(tmp.size()- 1);
                }
            }
        }

        boolean isPal(String s, int start, int end) {
            while ( start < end) {
                if ( s.charAt(start) != s.charAt(end)) {return false;}
                start++;end--;
            }
            return true;
        }
    }
}
