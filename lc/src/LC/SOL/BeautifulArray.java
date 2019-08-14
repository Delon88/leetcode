package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {
    class Solution {
        public int[] beautifulArray(int N) {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            while (ret.size() < N) {
                List<Integer> tmp = new ArrayList<>();
                for ( int i : ret) { if ( i * 2 - 1 <= N ) tmp.add(i * 2 - 1);}
                for ( int i : ret) { if ( i * 2 <= N ) tmp.add(i * 2);}
                ret = tmp;
            }
            int[] r = new int[ret.size()];
            for ( int i = 0 ;i < r.length; i++) r[i] = ret.get(i);
            return r;
        }
    }
}
