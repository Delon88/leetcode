package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nanhong on 1/15/2017.
 */
public class QueueReconstructionbyHeight {
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
            List<int[]> ret = new ArrayList<>();
            for (int[] p : people) {
                ret.add(p[1], p);
            }
            return ret.toArray(new int[people.length][]);
        }
    }
}
