package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> v = new HashSet<>();
            q.offer(start);
            v.add(start);
            while ( !q.isEmpty()) {
                int index = q.poll();
                if ( arr[index] == 0 ) return true;
                if ( index + arr[index] < arr.length && v.add(index + arr[index])) q.offer(index + arr[index]);
                if ( index - arr[index] >= 0 && v.add(index - arr[index]) ) q.offer(index - arr[index]);
            }
            return false;
        }
    }
}
