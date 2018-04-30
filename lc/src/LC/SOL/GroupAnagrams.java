package LC.SOL;

import java.util.*;

public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<>();
            for ( String str : strs) {
                char[] a = str.toCharArray();
                Arrays.sort(a);
                String ana = new String(a);
                if ( !map.containsKey(ana)) {map.put(ana, new ArrayList<>());}
                map.get(ana).add(str);
            }

            List<List<String>> ret = new ArrayList<>();
            for ( Map.Entry<String,List<String>> e : map.entrySet()) {
                ret.add(e.getValue());
            }
            return ret;
        }
    }
}
