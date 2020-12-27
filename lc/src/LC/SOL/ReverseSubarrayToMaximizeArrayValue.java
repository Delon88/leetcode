package LC.SOL;

public class ReverseSubarrayToMaximizeArrayValue {
    static class Solution {


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