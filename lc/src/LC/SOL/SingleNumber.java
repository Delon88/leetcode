package LC.SOL;

public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            if ( nums.length == 0 ) return -1;
            if ( nums.length == 1) return nums[0];
            for ( int i = 1 ; i < nums.length ; i++) {
                nums[0] = nums[0] ^ nums[i];
            }
            return nums[0];
        }
    }
}
