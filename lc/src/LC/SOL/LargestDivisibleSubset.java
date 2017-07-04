package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nanhong on 11/26/2016.
 */
public class LargestDivisibleSubset {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            int[] count = new int[n];
            int[] pre = new int[n];
            Arrays.sort(nums);
            int max = 0, index = -1;
            for (int i = 0; i < n; i++) {
                count[i] = 1;
                pre[i] = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        if (1 + count[j] > count[i]) {
                            count[i] = 1 + count[j];
                            pre[i] = j;
                        }
                    }
                }
                if (count[i] > max) {
                    max = count[i];
                    index = i;
                }
            }
            List<Integer> ret = new ArrayList<>();
            while (index != -1) {
                ret.add(nums[index]);
                index = pre[index];
            }
            return ret;
        }
    }
}
