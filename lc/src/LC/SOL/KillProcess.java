package LC.SOL;

import java.util.*;

public class KillProcess {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < pid.size(); i++) {
                if (map.containsKey(ppid.get(i))) {
                    map.get(ppid.get(i)).add(pid.get(i));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(pid.get(i));
                    map.put(ppid.get(i), list);
                }
            }

            List<Integer> ret = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(kill);
            while (!q.isEmpty()) {
                int tmp = q.poll();
                ret.add(tmp);
                if (map.get(tmp) != null) {
                    q.addAll(map.get(tmp));
                }
            }
            return ret;
        }
    }
}
