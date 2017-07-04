package LC.SOL;

/**
 * Created by nanhong on 11/26/2016.
 */
public class ValidPerfectSquare {

    static class Solution {
        public boolean isPerfectSquare(int num) {
            long start = 1, end = num;
            while (start <= end) {
                long mid = (start + end) / 2;
                if (num == mid * mid) return true;
                else if (num < mid * mid) end = mid - 1;
                else start = mid + 1;
            }
            return false;
        }
    }
}
