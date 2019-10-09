package LC.SOL;

public class MinimumSwapstoGroupAll1sTogether {
    class Solution {
        public int minSwaps(int[] data) {
            int ones = 0;
            for (int d : data) ones += d == 1 ? 1 : 0;
            if ( ones <= 1) return 0;
            int curOnes = 0;
            int ret = data.length;
            for (int j = 0; j < data.length; j++) {
                if (data[j] == 1) curOnes++;
                if (j >= ones - 1) {
                    ret = Math.min(ret , ones - curOnes);
                    if ( data[j - ones + 1] == 1 ) curOnes--;
                }
            }
            return ret;
        }
    }
}
