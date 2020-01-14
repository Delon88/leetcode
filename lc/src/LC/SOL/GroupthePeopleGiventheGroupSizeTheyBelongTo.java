package LC.SOL;

import java.util.*;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] gz) {
            List<List<Integer>> res = new ArrayList();
            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int i = 0; i < gz.length; ++i) {
                groups.putIfAbsent(gz[i], new ArrayList());
                List<Integer> list = groups.get(gz[i]);
                list.add(i);
                if ( list.size() == gz[i]) {groups.remove(gz[i]);res.add(list);}

            }
            return res;
        }
    }
}
