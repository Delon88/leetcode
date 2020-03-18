package LC.SOL;

import java.util.Random;

public class RandomPickwithWeight {
    class Solution {

        int[] w;
        Random rn = new Random();
        public Solution(int[] w) {
            this.w = w;
            for ( int i = 1; i < w.length; i++) {
                w[i] += w[i-1];
            }
        }

        public int pickIndex() {
            int n = w.length;
            int target = rn.nextInt(w[n - 1]) + 1;
            int start = 0, end = n - 1;
            while ( start < end ) {
                int mid = start + ( end - start) / 2;
                if ( w[mid] >= target ) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            if ( !(w[start] >= target) ) return n - 1;
            return start;
        }
    }
}
