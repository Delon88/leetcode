package LC.SOL;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class MaximumAverageSubarrayII {
    static class Solution {
        public double findMaxAverage(int[] nums, int k) {

            double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
            for (int n : nums) {
                l = Math.min(n, l);
                r = Math.max(n, r);
            }
            double mid = 0.0d;
            double error = Integer.MAX_VALUE;
            double prevmid = l;
            while ( error > 0.00001d  ) {
                mid = (l + r) * 0.5d;
                if ( find(nums, k , mid)) l = mid;
                else r = mid;
                error = Math.abs(mid - prevmid);
                prevmid = mid;
            }
            return l;
        }

        boolean find(int[] nums, int k , double target) {
            int n = nums.length;
            double curSum = 0 ;
            for ( int i = 0 ; i < k ; i++) {
                curSum += ( nums[i] - target);
            }
            if ( curSum >= 0 ) return true;
            double leftSum = 0 ;
            for ( int i = k ; i < n ; i++) {
                curSum += ( nums[i] - target);
                leftSum += ( nums[i - k] - target);
                if ( leftSum < 0 ) {
                    curSum -= leftSum;
                    leftSum = 0 ;
                }
                if ( curSum >= 0 ) return true;
            }
            return curSum >= 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,9,3,1,8,3,0,6,9,2};
        System.out.println(new Solution().findMaxAverage(nums, 8));
    }
}
