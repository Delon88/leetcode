package LC.SOL;

import java.util.TreeSet;

public class BraceExpansion {
    class Solution {
        public String[] expand(String S) {
            TreeSet<String> s = new TreeSet<>();
            if (S.length() == 0 ) return new String[]{""};
            else if ( S.length() == 1) return new String[]{S};
            if ( S.charAt(0) == '{') {
                int i = 0 ;
                while ( S.charAt(i) != '}') {
                    i++;
                }
                String e = S.substring(1 , i );
                String[] ops = e.split(",");
                String[] nextStrs = expand(S.substring(i + 1));
                for ( String op : ops ) {
                    for ( String nextStr : nextStrs) {
                        s.add(op + nextStr);
                    }
                }
            } else{
                String[] nextStrs = expand(S.substring(1));
                for ( String next : nextStrs) {
                    s.add(S.charAt(0) + next);
                }
            }
            return s.toArray(new String[0]);
        }
    }
}
