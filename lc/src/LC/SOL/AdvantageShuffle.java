package LC.SOL;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    class Solution {
        public int[] advantageCount(int[] A, int[] B) {
            Arrays.sort(A);
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for ( int i = 0 ; i < B.length ; i++) { q.offer( new int[]{B[i], i });}
            int low = 0 , high = A.length - 1; int[] ret = new int[A.length];
            while ( !q.isEmpty()) {
                int[] e = q.poll();
                if ( A[high] > e[0] ) {
                    ret[e[1]] = A[high];
                    high--;
                } else {
                    ret[e[1]] = A[low];
                    low++;
                }
            }
            return ret;
        }
    }
}
