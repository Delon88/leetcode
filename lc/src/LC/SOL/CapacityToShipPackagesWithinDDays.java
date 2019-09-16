package LC.SOL;

public class CapacityToShipPackagesWithinDDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int start = weights[0], end = weights[0];
            for ( int w : weights) {
                start = Math.max(w , start); end += w;
            }
            while ( start < end ) {
                int mid = start + ( end - start) / 2;
                if ( canShip(weights, mid, D)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }

        boolean canShip(int[] ws , int cap, int D){
            int days = 1;
            int sum = 0;
            for ( int w : ws ) {
                if ( sum + w > cap ){
                    days++;sum = w;
                } else {
                    sum+= w;
                }
            }
            return days <= D;
        }
    }
}
