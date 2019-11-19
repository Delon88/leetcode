package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceofGivenDifference {
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
                max = Math.max(max , map.get(arr[i]));
            }
            return max;
        }
    }
}
