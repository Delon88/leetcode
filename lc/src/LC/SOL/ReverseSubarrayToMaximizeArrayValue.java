package LC.SOL;

public class ReverseSubarrayToMaximizeArrayValue {
    static class Solution {
        public int maxValueAfterReverse(int[] nums) {
            int res = 0, n = nums.length;   
            for ( int i = 0 ; i < n - 1; i++) {
                res += Math.abs(nums[i + 1 ] - nums[i]);
            }
            int topline = Integer.MIN_VALUE;
            int botline = Integer.MAX_VALUE;
            for ( int i = 0; i < n - 1 ; i++) {
                topline = Math.max(topline, Math.min(nums[i], nums[i + 1]));
                botline = Math.min(botline, Math.max(nums[i], nums[i + 1]));
            }
            int d = Math.max(0 , (topline - botline) * 2);
            
            for ( int i = 1 ; i < n - 1 ; i++) {
                d = Math.max(d , Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i + 1] - nums[i]));
            }
            for ( int i = 0 ; i < n - 1 ; i++) {
                d = Math.max(d , Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i + 1] - nums[i]));
            }
            return res + d;
        }

    }


    static class Solution1 {
        public int maxValueAfterReverse(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE;
            for ( int i = 0 ; i < n ; i++ ) {
                for ( int j = i + 1 ; j < n - 1 ; j++) {
                    reverse(nums, i, j);
                    max = Math.max(max, sum(nums));
                    reverse(nums, i, j);
                }
            }
            return max;
        }

        void reverse(int[] nums, int i , int j){
            while ( i < j ) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t; i++; j--;
            }
        }

        int sum(int[] nums) {
            int sum = 0;
            for ( int i =  1 ; i < nums.length; i++) {
                sum += Math.abs(nums[i] - nums[i - 1]);
            }
            return sum;
        }
    }
}