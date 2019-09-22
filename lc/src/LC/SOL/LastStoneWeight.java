package LC.SOL;

import java.util.PriorityQueue;

public class LastStoneWeight {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int s : stones) pq.offer(s);
            while (pq.size() > 1) {
                pq.offer(pq.poll() - pq.poll());
            }
            return pq.peek();
        }
    }
}
