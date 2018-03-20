package LC.SOL;

public class KEmptySlots {
    class Solution {
        public int kEmptySlots(int[] flowers, int k) {
            int n = flowers.length;
            int[] days = new int[n];
            for ( int i = 0 ; i < n ; i++) {
                days[flowers[i] - 1] = i + 1;
            }
            int start = 0 , end = k + 1;
            int ret = Integer.MAX_VALUE;
            for ( int i = 1 ; end < n ; i++) {
                if ( days[i] > days[start] && days[i] > days[end]) {
                    continue;
                }
                if ( i == end ) {
                    ret = Math.min(ret, Math.max(days[start], days[end]));
                }
                end = i + k + 1;
                start = i;
            }
            return ret == Integer.MAX_VALUE ? -1: ret;
        }
    }
}
