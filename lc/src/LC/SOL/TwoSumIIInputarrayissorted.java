package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputarrayissorted {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] ret = {0 , 0};
            if ( numbers == null  || numbers.length < 2) return ret;
            int start = 0 , end = numbers.length - 1;
            while ( start < end ) {
                int sum = numbers[start] + numbers[end];
                if ( sum == target) {
                    return new int[]{start + 1 , end + 1};
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return ret;
        }
    }
}
