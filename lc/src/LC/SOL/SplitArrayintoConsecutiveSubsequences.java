package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> exist = new HashMap<>();
            for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
            for (int i : nums) {
                if (freq.get(i) == 0) continue;
                if (exist.getOrDefault(i, 0) > 0) {
                    exist.put(i, exist.get(i) - 1);
                    exist.put(i + 1, exist.getOrDefault(i + 1, 0) + 1);
                } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                    freq.put(i + 1, freq.get(i + 1) - 1);
                    freq.put(i + 2, freq.get(i + 2) - 1);
                    exist.put(i + 3, exist.getOrDefault(i + 3, 0) + 1);
                } else {
                    return false;
                }
                freq.put(i, freq.get(i) - 1);
            }
            return true;
        }
    }
}
