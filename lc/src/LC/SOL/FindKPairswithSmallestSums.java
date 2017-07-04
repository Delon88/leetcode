package LC.SOL;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by nanhong on 11/27/2016.
 */
public class FindKPairswithSmallestSums {
    static class Solution {

        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> ret = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0) return ret;
            PriorityQueue<int[]> q = new PriorityQueue<>
                    (k, (a, b) -> Integer.valueOf(a[0] + a[1]).compareTo(b[0] + b[1]));

            for (int i = 0; i < nums1.length && i < k; i++) {
                q.offer(new int[]{nums1[i], nums2[0], 0});
            }

            for (int i = 0; i < k && !q.isEmpty(); i++) {
                int[] cur = q.poll();
                ret.add(new int[]{cur[0], cur[1]});
                if (cur[2] + 1 < nums2.length) {
                    q.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
                }
            }

            return ret;
        }
    }
}
