package LC.SOL;

import java.util.*;

public class SmallestRange {

    class Solution {

        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Ele> q = new PriorityQueue<>((a, b) -> a.val - b.val);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> num = nums.get(i);
                q.offer(new Ele(num.get(0), i, 0));
                max = Math.max(max, num.get(0));
            }
            int start = 0, end = Integer.MAX_VALUE;
            while (q.size() == nums.size()) {
                Ele e = q.poll();
                if (max - e.val < end - start) {
                    start = e.val;
                    end = max;
                }
                if (e.index + 1 < nums.get(e.row).size()) {
                    int nextVal = nums.get(e.row).get(e.index + 1);
                    q.offer(new Ele(nextVal, e.row, e.index + 1));
                    if (nextVal > max) {
                        max = nextVal;
                    }
                }
            }
            return new int[]{start, end};
        }

        class Ele {
            int val;
            int row;
            int index;

            public Ele(int val, int row, int index) {
                this.val = val;
                this.row = row;
                this.index = index;
            }
        }
    }
}
