package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( nums.length <= 3) return ret;
            Arrays.sort(nums);
            if ( nums.length == 0 ) return ret;
            int n = nums.length;
            for (int i = 0; i < n - 3; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < n - 2; j++) {
                    if ( j != i + 1 && nums[j] == nums[j - 1]) continue;
                    int l = j + 1;
                    int r = n - 1;
                    while ( l < r ) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if ( sum > target) {
                            r--;
                        } else if ( sum < target) {
                            l++;
                        } else {
                            ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while ( l < r && nums[l] == nums[l + 1]) {l++;}
                            while ( l < r && nums[r] == nums[r -1] ) {r--;}
                            l++;r--;
                        }
                    }
                }
            }
            return ret;
        }
    }
}
