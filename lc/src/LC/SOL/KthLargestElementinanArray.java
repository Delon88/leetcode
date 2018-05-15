package LC.SOL;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>(k);
            for ( int i : nums) {
                q.offer(i);
                if ( q.size() > k ) {
                    q.poll();
                }
            }
            return q.peek();
        }
    }
}
