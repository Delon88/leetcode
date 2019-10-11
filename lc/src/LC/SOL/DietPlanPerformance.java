package LC.SOL;

public class DietPlanPerformance {
    class Solution {
        public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
            int sum = 0 ,ret = 0 ;
            for( int i = 0 ; i < calories.length ; i++) {
                sum += calories[i];
                if ( i >= k - 1 ) {
                    if ( sum < lower) ret--;
                    else if ( sum > upper) ret++;
                    sum -= calories[i - k + 1];
                }
            }
            return ret;
        }
    }
}
