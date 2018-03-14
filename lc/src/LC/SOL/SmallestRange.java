package LC.SOL;

import java.util.*;

public class SmallestRange {
    class Solution {


//        You have k lists of sorted integers in ascending order. Find the smallest range that includes
//        at least one number from each of the k lists.
//
//        We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
//        Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//        Output: [20,24]
//        Explanation:
//        List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//        List 2: [0, 9, 12, 20], 20 is in range [20,24].
//        List 3: [5, 18, 22, 30], 22 is in range [20,24].

        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Map.Entry<Integer, Iterator<Integer>>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());

            int max = Integer.MIN_VALUE;
            for (List<Integer> list : nums) {
                if (list == null || list.size() == 0) return null;
                max = Math.max(max, list.get(0));
                pq.add(new AbstractMap.SimpleEntry<>(list.get(0), list.iterator()));
            }

            int minRange = Integer.MAX_VALUE;
            int start = Integer.MAX_VALUE;

            while (pq.size() == nums.size()) {
                if (max - pq.peek().getKey() < minRange) {
                    minRange = max - pq.peek().getKey();
                    start = pq.peek().getKey();
                }
                Map.Entry<Integer, Iterator<Integer>> entry = pq.poll();
                if (entry.getValue().hasNext()) {
                    int nextVal = entry.getValue().next();
                    max = Math.max(nextVal, max);
                    pq.add(new AbstractMap.SimpleEntry<>(nextVal, entry.getValue()));
                } else {
                    break;
                }
            }
            return new int[]{start, start + minRange};
        }
    }
}
