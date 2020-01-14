package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> ret = new ArrayList<>();
            for (int[] in : intervals) {
                if (in[1] < toBeRemoved[0] || in[0] > toBeRemoved[1]) {
                    ret.add(Arrays.asList(in[0], in[1]));
                } else {
                    if(in[0] < toBeRemoved[0]) // left end no overlap.
                        ret.add(Arrays.asList(in[0], toBeRemoved[0]));
                    if (in[1] > toBeRemoved[1]) // right end no overlap.
                        ret.add(Arrays.asList(toBeRemoved[1], in[1]));
                }
            }
            return ret;
        }
    }
}
