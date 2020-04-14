package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
    class Solution {
        public int[] decompressRLElist(int[] nums) {
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i += 2) {
                for ( int j = 0 ; j < nums[i]; j++) {
                    t.add(nums[i + 1]);
                }
            }
            int[] ret = new int[t.size()];
            for ( int i = 0; i < ret.length ; i++) ret[i] = t.get(i);
            return ret;
        }
    }
}
