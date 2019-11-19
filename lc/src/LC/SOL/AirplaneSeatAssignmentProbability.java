package LC.SOL;

public class AirplaneSeatAssignmentProbability {
    class Solution {
        public double nthPersonGetsNthSeat(int n) {
            if (n == 1) return 1.0d;
            return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
        }
    }
}
