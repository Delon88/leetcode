package LC.SOL;

public class StatisticsfromaLargeSample {
    class Solution {
        public double[] sampleStats(int[] count) {
            double min = Double.MAX_VALUE, max = Double.MIN_VALUE, mean = 0, median = 0;
            int c = 0;
            for ( int i = 0 ; i < count.length ;i++) {
                if ( count[i] > 0 ) {
                    min = Math.min(min, count[i]);
                    max = Math.min(max, count[i]);
                }
            }
        }
    }
}
