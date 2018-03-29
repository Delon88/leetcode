package LC.SOL;

import java.util.Arrays;

public class MinimizeMaxDistancetoGasStation {
    class Solution {
        public double minmaxGasDist(int[] stations, int K) {
            int n = stations.length;
            double low = 0, high = stations[n - 1] - stations[0], mid = 0.0d;
            while (low + 1e-6 < high) {
                mid = low + (high - low) / 2;
                int count = 0;
                for (int i = 0; i < n - 1; i++) {
                    count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
                }
                if (count <= K) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
            return low;
        }
    }
}
