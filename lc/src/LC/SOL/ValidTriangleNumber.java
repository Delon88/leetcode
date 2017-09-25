package LC.SOL;

import java.util.Arrays;

public class ValidTriangleNumber {
    class Solution {
        public int triangleNumber(int[] nums) {
            int ret = 0 ;
            if ( nums.length < 3 ) return 0;
            Arrays.sort(nums);

            for ( int i = 2 ; i < nums.length ; i++) {
                int left = 0 , right = i - 1;
                while ( left < right ) {
                    if ( nums[left] + nums[right] > nums[i]) {
                        ret += ( right - left);
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return ret;
        }
    }
}
