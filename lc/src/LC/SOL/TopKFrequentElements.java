package LC.SOL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for ( int i : nums) {
                map.put(i , map.getOrDefault(i , 0 ) + 1);
            }
            List<Integer>[] buckets = new List[nums.length + 1];
            for ( Integer key: map.keySet()) {
                int freq = map.get(key);
                if ( buckets[freq] == null ) {
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(key);
            }

            List<Integer> ret = new ArrayList<>();
            for ( int i = buckets.length - 1; i >= 0 && ret.size() < k ; i--) {
                if ( buckets[i] != null ) {
                    ret.addAll(buckets[i]);
                }
            }
            return ret;
        }
    }
}
