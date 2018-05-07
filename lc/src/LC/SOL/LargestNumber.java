package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> ret = new ArrayList<>();
            for (int n : nums) {
                ret.add(Integer.toString(n));
            }
            Collections.sort(ret, (a, b) -> {
                return (b + a).compareTo(a + b);
            });
            StringBuilder b = new StringBuilder();
            for ( String n : ret) {
                b.append(n);
            }
            if ( b.charAt(0) == '0') return "0";
            return b.toString();
        }
    }
}
