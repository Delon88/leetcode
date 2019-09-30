package LC.SOL;

import java.util.Arrays;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    class Solution {

        int[] id;
        public int earliestAcq(int[][] logs, int N) {
            id = new int[N];
            Arrays.sort(logs, (l1, l2) -> l1[0] - l2[0]);
            for ( int i = 0 ; i < id.length; i++) id[i] = i;
            for (int[] l : logs) {
                int ri = find(l[1]), rj = find(l[2]);
                if ( ri != rj) N--;
                id[ri] = rj;
                if ( N == 1 ) return l[0];
            }
            return -1;
        }

        int find(int i ) {
            while ( i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    }
}
