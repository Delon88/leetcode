package LC.SOL;


public class JudgeRouteCircle {
    class Solution {
        public boolean judgeCircle(String moves) {
            if ( moves.length() == 0 ) return false;
            int[] cur = {0,0};
            for ( int i = 0 ; i < moves.length() ; i++) {
                char c = moves.charAt(i);
                if ( c == 'U') {
                    cur[1]++;
                } else if ( c == 'L') {
                    cur[0]--;
                } else if ( c == 'D') {
                    cur[1]--;
                } else if ( c == 'R') {
                    cur[0]++;
                }
            }
            return cur[0] == 0 && cur[1] == 0;
        }
    }
}
