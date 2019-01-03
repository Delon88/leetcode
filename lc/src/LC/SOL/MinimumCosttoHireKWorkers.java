package LC.SOL;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
            int n = quality.length;
            double[][] workers = new double[n][2];
            for (int i = 0; i < n; i++) {
                workers[i] = new double[]{(double) wage[i] / quality[i], (double) quality[i]};
            }
            Arrays.sort(workers, (a , b) -> Double.compare(a[0] , b[0]));
            PriorityQueue<Double> pq = new PriorityQueue<>();
            double qsum = 0d, ret = Double.MAX_VALUE;
            for ( double[] worker : workers) {
                qsum += worker[1];
                pq.offer(-worker[1]);
                if ( pq.size() > K) qsum += pq.poll();
                if ( pq.size() == K ) ret = Math.min(ret , qsum * worker[0]);
            }
            return ret;
        }
    }
}
