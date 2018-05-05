package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> ret = new ArrayList<>();
            long prev = (long) lower -1;
            for ( int i = 0 ; i <= nums.length ; i++) {
                long cur = ( i == nums.length ? (long) upper + 1: nums[i]);
                if ( cur - prev >= 2) {
                    ret.add(getRange(prev + 1 , cur -1));
                }
                prev = cur;
            }
            return ret;
        }

        String getRange(long start, long end ) {
            if ( start == end ) return "" + start;
            else return start + "->" + end;
        }
    }
}
