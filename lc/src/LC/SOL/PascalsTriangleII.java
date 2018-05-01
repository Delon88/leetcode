package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> prev = new ArrayList<>();
            prev.add(1);
            List<Integer> cur = new ArrayList<>();
            if ( rowIndex == 0 ) return prev;
            for ( int i = 1 ; i < rowIndex ; i++) {
                cur.add(prev.get(0));
                for ( int j = 1 ; j < prev.size() ; j++) {
                    cur.add(prev.get(j) + prev.get(j - 1));
                }
                cur.add(prev.get(prev.size() - 1));
                List<Integer> tmp = prev;
                prev = cur;
                tmp.clear();
                cur = tmp;
            }
            return prev;
        }
    }
}
