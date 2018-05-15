package LC.SOL;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < k || k <= 0) return new int[0];
            int n = nums.length;
            int[] ret = new int[n - k + 1];
            int rIndx = 0;
            Deque<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if ( !q.isEmpty() && q.peek() < i - k + 1) {
                    q.poll();
                }
                while ( !q.isEmpty() && nums[q.peekLast()] < nums[i] ) {
                    q.pollLast();
                }
                q.offer(i);
                if ( i >= k - 1 ) {
                    ret[rIndx++] = nums[q.peek()];
                }
            }
            return ret;
        }
    }
}
