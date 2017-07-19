package LC.SOL;

import java.util.List;

public class SequenceReconstruction {
    public class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

            if (seqs.size() == 0) return false;

            int[] idx = new int[org.length + 1];
            for (int i = 0; i < org.length; i++) {
                idx[org[i]] = i;
            }

            boolean[] pairs = new boolean[org.length];

            for ( List<Integer> seq : seqs) {
                for ( int i = 0 ; i < seq.size() ; i++) {
                    // check for point range.
                    if ( seq.get(i) < 0 || seq.get(i) > org.length ) {
                        return false;
                    }

                    if ( i > 0 && idx[seq.get(i - 1)] >= idx[seq.get(i)] ) {
                        return false;
                    }

                    if ( i > 0 &&  idx[seq.get(i - 1)] + 1 == idx[seq.get(i)] ) {
                        pairs[idx[seq.get(i  - 1)] ] = true;
                    }
                }
            }

            if ( pairs.length == 1 ) {
                for ( List<Integer> seq : seqs) {
                    if ( seq.size() == 1 ) return true;
                }
                return false;
            }

            for ( int i = 0  ; i < pairs.length - 1; i++) {
                if ( !pairs[i] ) return false;
            }
            return true;
        }

    }
}
