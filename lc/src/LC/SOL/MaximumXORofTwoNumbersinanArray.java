package LC.SOL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nanhong on 1/22/2017.
 */
public class MaximumXORofTwoNumbersinanArray {
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                mask = mask | (1 << i);
                Set<Integer> set = new HashSet<>();
                for (int num : nums) {
                    set.add(mask & num);
                }
                int tmp = max | (1 << i);
                for (int prefix : set) {
                    if (set.contains(tmp ^ prefix)) {
                        max = tmp;
                        break;
                    }
                }

            }
            return max;
        }
    }
}
