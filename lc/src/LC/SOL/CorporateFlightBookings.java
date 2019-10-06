package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class CorporateFlightBookings {
    class SolutionTLE {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] b : bookings) {
                for (int i = b[0]; i <= b[1]; i++) map.put(i, map.getOrDefault(i, 0) + b[2]);
            }
            int[] ret = new int[n];
            for ( int i = 1 ; i <= n ; i++) ret[i - 1] = map.getOrDefault(i , 0);
            return ret;
        }
    }

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] sum = new int[n];
            for ( int[] b : bookings) {
                sum[b[0] - 1] += b[2];
                if ( b[1] < n ) sum[b[1]] -= b[2];
            }
            int cur = 0;
            int[] ret = new int[n];
            for ( int i = 0 ; i < sum.length; i++) {
                cur+= sum[i];
                ret[i] = cur;
            }
            return ret;
        }
    }
}
