package LC.SOL;

public class BinaryGap {
    class Solution {
        public int binaryGap(int N) {
            int lastPos = -1, ret = Integer.MIN_VALUE;
            for (int i = 0; i < 31; i++) {
                if ( (( N >> i) & 1) == 1) {
                    if ( lastPos != -1 ) {
                        ret = Math.max( i - lastPos  , ret);
                    }
                    lastPos = i;
                }
            }
            return ret == Integer.MIN_VALUE ? 0 : ret;
        }
    }
}
