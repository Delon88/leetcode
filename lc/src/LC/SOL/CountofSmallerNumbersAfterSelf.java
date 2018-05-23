package LC.SOL;

import java.util.*;

public class CountofSmallerNumbersAfterSelf {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            Map<Integer,Integer> map = new HashMap<>();
            int rank = 1;
            for ( int i : sorted) {
                if ( !map.containsKey(i)) {
                    map.put(i, rank);
                    rank++;
                }
            }
            int[] bit = new int[map.size() + 1];
            List<Integer> ret = new ArrayList<>();
            for (  int i = nums.length - 1 ; i >= 0 ; i--) {
                ret.add(query(bit, map.get(nums[i]) - 1 ));
                update(bit, map.get(nums[i]) , 1);
            }
            Collections.reverse(ret);
            return ret;
        }

        public void update(int[] bit, int index, int value) {
            while (index < bit.length) {
                bit[index] += value;
                index += (index & -index);
            }
        }

        public int query(int[] bit, int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= (index & -index);
            }
            return sum;
        }
    }
}
