package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;
            for (int i = 30; i >= 0; i--) {
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
