package LC.SOL;

public class RemoveDuplicatesfromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int j = 0;
            for ( int i = 0 ; i < nums.length ; ) {
                int num = nums[i];
                while ( i < nums.length && nums[i] == num) {
                    i++;
                }
                nums[j++] = num;
            }
            return j;
        }
    }
}
