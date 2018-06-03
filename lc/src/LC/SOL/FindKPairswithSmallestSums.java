package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    static class Solution {

        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> q = new PriorityQueue<>(k , (a , b) -> Integer.valueOf(a[0] + a[1]).compareTo(b[0] + b[1]));
            List<int[]> ret = new ArrayList<>();
            if ( nums1 == null || nums2 == null || nums2.length == 0 ) return ret;
            for ( int i = 0 ;i < nums1.length && i < k ; i++ ) { q.offer(new int[]{nums1[i], nums2[0], 0});}
            for ( int i = 0 ; i < k && !q.isEmpty(); i++) {
                int[] node = q.poll();
                ret.add(new int[]{node[0] , node[1]});
                if ( node[2] < nums2.length - 1 ) {
                    q.offer(new int[]{node[0] , nums2[node[2] + 1] , node[2] + 1});
                }
            }
            return ret;
        }
    }
}
