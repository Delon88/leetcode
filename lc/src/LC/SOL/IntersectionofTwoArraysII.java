package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if ( nums1.length > nums2.length ) return intersect(nums2, nums1);
            Map<Integer,Integer> map = new HashMap<>();
            for ( int n : nums1) {
                map.put(n , map.getOrDefault(n , 0) + 1);
            }
            List<Integer> tmp = new ArrayList<>();
            for ( int n: nums2) {
                if ( map.containsKey(n)) {
                    tmp.add(n);
                    map.put(n , map.get(n) - 1);
                    if ( map.get(n) == 0 ) map.remove(n);
                }
            }
            int[] ret = new int[tmp.size()];
            for ( int i = 0 ;i < tmp.size() ; i++) {
                ret[i] = tmp.get(i);
            }
            return ret;
        }
    }
}
