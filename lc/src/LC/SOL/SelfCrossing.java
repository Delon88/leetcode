package LC.SOL;

public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if ( x.length <= 3 ) return false;
        int len = x.length;
        for ( int i = 3 ; i < len ; i++) {
            // case 1: fourth line cross first
            if ( x[i] >= x[i - 2] && x[i -3 ] >= x[i - 1]) return true;
            // case 2: fifth line cross first
            if ( i >= 4) {
                if (x[i] >= x[i - 2] - x[i - 4] && x[i - 3] == x[i - 1] ) return true;
            }
            if ( i >= 5) {
                if ( x[i - 2] >= x[i - 4] && x[i] >= x[i- 2] - x[i - 4] && x[i - 1]  >= x[i - 3] - x[i - 5] && x[i -1] <= x[i - 3]) return true;
            }
        }
        return false;
    }
}
