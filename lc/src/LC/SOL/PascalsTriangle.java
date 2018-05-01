package LC.SOL;

import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( numRows == 0 ) return ret;
            ret.add( new ArrayList<>(Arrays.asList(1)));
            if ( numRows == 1) return ret;
            for ( int i = 1 ; i < numRows ; i++) {
                List<Integer> prev = ret.get(ret.size() - 1);
                List<Integer> next = new ArrayList<>();
                next.add(prev.get(0));
                for( int j = 1 ; j < prev.size();  j++) {
                    next.add(prev.get(j) + prev.get(j -1));
                }
                next.add(prev.get(prev.size() - 1));
                ret.add(next);
            }
            return ret;
        }
    }
}
