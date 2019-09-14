package LC.SOL;

import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for ( int a : A) q.offer(a);
            while ( K-- > 0 ) q.offer(-q.poll());
            int sum = 0;
            for ( int i = 0; i < A.length ; i++) sum+= q.poll();
            return sum;
        }
    }
}
