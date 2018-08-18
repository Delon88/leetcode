package LC.SOL;

import java.util.Arrays;

public class MostProfitAssigningWork {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int[][] jobs = new int[difficulty.length][2];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = difficulty[i];
                jobs[i][1] = profit[i];
            }
            Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
            Arrays.sort(worker);
            int maxp = 0;
            int i = 0;
            int ret =0;
            for (int w : worker) {
                while ( i < n && w >= jobs[i][0]) {
                    maxp = Math.max(maxp, jobs[i][1]);
                    i++;
                }
                ret += maxp;
            }
            return ret;
        }
    }
}
