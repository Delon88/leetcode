package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class NumberofRecentCalls {
    class RecentCounter {

        TreeSet<Integer> set;
        public RecentCounter() {
            set = new TreeSet<>();
        }

        public int ping(int t) {
            set.add(t);
            return set.subSet(t - 3000, t + 1).size();
        }
    }

    class RecentCounterQueue {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.offer(t);
            while ( q.peek() < t - 3000 ) q.poll();
            return q.size();
        }
    }
}
