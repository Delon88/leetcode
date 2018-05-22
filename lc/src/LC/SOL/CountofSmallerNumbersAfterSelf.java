package LC.SOL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountofSmallerNumbersAfterSelf {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for ( int i : nums) { map.put(i, map.getOrDefault(i, 0) + 1);}
            int[] bit = new int[map.size() + 1];
            for( int i = nums.length - 1 ;
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
