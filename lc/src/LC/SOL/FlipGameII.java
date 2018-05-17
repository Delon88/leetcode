package LC.SOL;

public class FlipGameII {
    class Solution {
        public boolean canWin(String s) {
            int index = -1;
            while ( (index = s.indexOf("++", index + 1)) != -1 ) {
                if ( !canWin(s.substring(0 , index) + "--" + s.substring(index + 2))) return true;
            }
            return false;
        }
    }
}
