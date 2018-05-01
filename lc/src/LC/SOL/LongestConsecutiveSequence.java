package LC.SOL;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length * 2);
            for ( int n : nums) {
                set.add(n);
            }
            int max = 0;
            for ( int n : nums) {
                if ( set.contains(n)) {
                    set.remove(n);
                    int left = n - 1;
                    while ( set.contains(left)) {
                        set.remove(left);
                        left--;
                    }
                    int right = n + 1;
                    while ( set.contains(right)) {
                        set.remove(right);
                        right++;
                    }
                    max = Math.max(max, right - left - 1);
                }
            }
            return max;
        }
    }
}
