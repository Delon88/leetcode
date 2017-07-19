package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for ( int i = 0 ; i < nums.length ; i++) {
                int indNumber = nums[ Math.abs(nums[i])  -1];
                if ( indNumber > 0 ) {
                    nums[ Math.abs(nums[i])  -1] = -indNumber;
                } else {
                    list.add( Math.abs(nums[i]));
                }
            }
            return list;
        }
    }
}
