package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                mask |= (1 << i);
                HashSet<Integer> set = new HashSet<>();
                for (int num : nums) {
                    set.add(num & mask); // reserve Left bits and ignore Right bits
                }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
                int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
                for (int prefix : set) {
                    if (set.contains(tmp ^ prefix)) {
                        max = tmp;
                    }
                }
            }
            return max;
        }
    }
}
