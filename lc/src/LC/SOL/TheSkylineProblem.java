package LC.SOL;

import java.util.*;

public class TheSkylineProblem {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<int[]> heights = new ArrayList<>();
            for ( int[] b : buildings) {
                heights.add(new int[]{ b[0], -b[2]});
                heights.add(new int[]{ b[1] , b[2]});
            }
            Collections.sort(heights, (a , b) -> { if ( a[0] != b[0] ) return a[0] - b[0];else return a[1] - b[1];});
            TreeMap<Integer,Integer> map = new TreeMap<>((a , b) -> b - a);
            map.put(0 , 1);
            int prev = 0;
            List<List<Integer>> ret = new ArrayList<>();
            for ( int[] h : heights) {
                if ( h[1] < 0 ) {
                    map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
                } else {
                    map.put(h[1], map.get(h[1]) - 1);
                    if ( map.get(h[1]) <= 0 ) map.remove(h[1]);
                }
                int cur = map.firstKey();
                if ( cur != prev ) {
                    ret.add(Arrays.asList(h[0], cur));
                    prev = cur;
                }
            }
            return ret;
        }
    }
}
