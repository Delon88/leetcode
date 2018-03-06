package LC.SOL;


import java.util.PriorityQueue;

public class IPO {
    class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            PriorityQueue<int[]> profitQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            PriorityQueue<int[]> captitalQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int i = 0; i < Capital.length; i++) {
                captitalQ.add(new int[]{Capital[i], Profits[i]});
            }

            for (int i = 0; i < k && i < Profits.length; i++) {
                while (!captitalQ.isEmpty() && captitalQ.peek()[0] <= W) {
                    profitQ.add(captitalQ.poll());
                }
                if (!profitQ.isEmpty()) {
                    W += profitQ.poll()[1];
                }
            }
            return W;
        }
    }
}
