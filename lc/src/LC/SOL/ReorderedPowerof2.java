package LC.SOL;

public class ReorderedPowerof2 {
    class Solution {
        public boolean reorderedPowerOf2(int N) {
            if ( N == 1 ) return true;
            return ( N ^  (N -1) ) == 0 ;
        }
    }
}
