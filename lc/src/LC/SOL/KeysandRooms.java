package LC.SOL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysandRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> v = new HashSet<>();
            dfs( 0 , rooms, v);
            return v.size() == rooms.size();
        }

        void dfs(int cur, List<List<Integer>> rooms, Set<Integer> v) {
            if ( v.contains(cur)) return;
            v.add(cur);
            for ( Integer next : rooms.get(cur)) {
                if ( !v.contains(next)) dfs(next, rooms, v );
            }
        }
    }
}
