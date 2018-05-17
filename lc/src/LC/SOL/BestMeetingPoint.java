package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    class Solution {
        public int minTotalDistance(int[][] grid) {
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for ( int i = 0 ; i < grid.length ;i++) {
                for ( int j =0  ; j < grid[0].length; j++) {
                    if ( grid[i][j] == 1 ) {
                        x.add(i);y.add(j);
                    }
                }
            }

            Collections.sort(y);
            return getSumDist(x) + getSumDist(y);
        }

        int getSumDist(List<Integer> list ) {
            int start = 0, end = list.size() - 1;
            int ret = 0 ;
            while ( start < end ) {
                ret += list.get(end--) - list.get(start++);
            }
            return ret;
        }
    }
}
