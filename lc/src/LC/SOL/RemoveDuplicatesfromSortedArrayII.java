package LC.SOL;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            Arrays.sort(nums);
            int len =0 ;
            for ( int i = 0 ; i < nums.length;) {
                int cur = nums[i];
                int count = 0;
                while ( i < nums.length && cur == nums[i] ) {
                    i++;
                    count++;
                }

                nums[len++] = cur;
                if ( count >= 2 ) {
                    nums[len++] = cur;
                }
            }
            return len;
        }
    }
}
