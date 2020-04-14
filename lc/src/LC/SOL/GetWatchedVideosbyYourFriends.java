package LC.SOL;

import java.util.*;

public class GetWatchedVideosbyYourFriends {
    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            // find all friends
            Queue<Integer> q = new LinkedList<>();
            q.add(id);
            int count = 0;
            Set<Integer> visited = new HashSet<>();
            visited.add(id);
            while (!q.isEmpty() && count != level) {
                for (int size = q.size() ; size > 0 ; size--) {
                    int p = q.poll();
                    for (int f : friends[p]) {
                        if (visited.add(f)) {
                            q.add(f);
                        }
                    }
                }
                count++;
            }
            // count friend's watchedVideos
            Map<String, Integer> map = new HashMap<>();
            List<String> res = new ArrayList<>();
            while (!q.isEmpty()) {
                int p = q.poll();
                List<String> vs = watchedVideos.get(p);
                for (String v : vs) {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
            }
            for (String key : map.keySet()) {
                res.add(key);
            }
            Collections.sort(res, (a, b) -> (map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b)));
            return res;
        }
    }
}
