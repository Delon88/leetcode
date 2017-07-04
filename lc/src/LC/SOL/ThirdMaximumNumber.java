package LC.SOL;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by nanhong on 1/15/2017.
 */
public class ThirdMaximumNumber {
    public class Solution {
        public int thirdMax(int[] nums) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (!set.contains(n)) {
                    set.add(n);
                    q.offer(n);
                    if (q.size() > 3) {
                        set.remove(q.poll());
                    }
                }
            }
            if (q.size() == 2) q.poll();
            return q.peek();
        }

        public int thirdMax1(int[] nums) {
            Integer m1 = null;
            Integer m2 = null;
            Integer m3 = null;
            for (Integer n : nums) {
                if (n.equals(m1) || n.equals(m2) || n.equals(m3)) continue;
                if (m1 == null || n > m1) {
                    m3 = m2;
                    m2 = m1;
                    m1 = n;
                } else if (m2 == null || n > m2) {
                    m3 = m2;
                    m2 = n;
                } else if (m3 == null || n > m3) {
                    m3 = n;
                }
            }
            return m3 == null ? m1 : m3;
        }
    }
}
