package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int indNumber = nums[Math.abs(nums[i]) - 1];
                if (indNumber > 0) {
                    nums[Math.abs(nums[i]) - 1] = -indNumber;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    ret.add(i + 1);
                }
            }
            return ret;
        }
    }
}
