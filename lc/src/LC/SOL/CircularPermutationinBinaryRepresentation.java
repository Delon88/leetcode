package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationinBinaryRepresentation {
    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> ret = new ArrayList<>();
            for ( int i = 0 ; i < ( 1 << n ) ; i++) {
                ret.add( start ^ i ^ ( i >> 1));
            }
            return ret;
        }
    }
}
