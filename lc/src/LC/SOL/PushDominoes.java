package LC.SOL;

public class PushDominoes {
    class Solution {
        public String pushDominoes(String dominoes) {
            String d = "L" + dominoes + "R";
            StringBuilder b = new StringBuilder();
            for (int i = 0, j = 0; j < d.length(); j++) {
                char c = d.charAt(j);
                if (c == '.') continue;
                if (i > 0) b.append(d.charAt(i));
                int dots = j - i - 1;
                // case 1) L . R
                if ( d.charAt(i) == 'L' && d.charAt(j) == 'R') {
                    for ( int k = 0 ; k < dots ; k++) b.append('.');
                } // case 3) 4)
                else if ( d.charAt(i) == d.charAt(j)) {
                    for ( int k = 0 ; k < dots ; k++) b.append(d.charAt(i));
                } // case 1
                else {
                    for ( int k = 0 ; k < dots / 2 ; k++) b.append('R');
                    if ( dots % 2 == 1 ) b.append('.');
                    for ( int k = 0 ; k < dots/ 2 ; k++) b.append('L');
                }
                i = j ;
            }
            return b.toString();
        }
    }
}
