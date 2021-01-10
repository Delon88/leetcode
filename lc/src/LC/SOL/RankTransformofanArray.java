package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RankTransformofanArray {
    class Solution {
        public int[] arrayRankTransform(int[] arr) {

            TreeMap<Integer,Integer> sort = new TreeMap<>();
            for ( int i : arr) {
                sort.put(i, sort.getOrDefault(i, 0) + 1);
            }
            
            Map<Integer,Integer> map = new HashMap<>();
            int rank = 1;
            for ( Map.Entry<Integer,Integer> e : sort.entrySet()){
                map.put(e.getKey(), rank);
                rank++;
            }
            int[] ret = new int[arr.length];
            for ( int i = 0 ; i < arr.length ; i++) {
                ret[i] = map.get(arr[i]);
            }
            return ret;
        }
    }
}
