package LC.SOL;

import java.util.*;

public class RepeatedDNASequences {
    class Solution {
        Map<Character, Integer> map = new HashMap<>();

        {
            map.put('A', 0);
            map.put('C', 1);
            map.put('G', 2);
            map.put('T', 3);
        }

        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> ret = new HashSet<>();
            Set<Integer> set = new HashSet<>();
            int mask = 0xFFFFF;
            if (s.length() < 10) return new ArrayList<>();
            int end = 0, num = 0;
            for (; end < s.length(); end++) {
                num = ((num << 2) | map.get(s.charAt(end))) & mask;
                if ( end >= 9 && !set.add(num)) {
                    ret.add(s.substring(end - 9, end + 1));
                }
            }
            return new ArrayList<>(ret);
        }
    }
}
