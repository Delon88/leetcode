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
            Set<String> repeated = new HashSet<>();
            Set<Integer> set = new HashSet<>();
            int mask = 0xFFFFF;
            if (s.length() < 10) return new ArrayList<>();
            int start = 0, end = 0, num = 0;
            for (; end < 10; end++) {
                num = ((num << 2) | map.get(s.charAt(end))) & mask;
            }
            start++;
            set.add(num);
            for (; end < s.length(); end++, start++) {
                num = ((num << 2) | map.get(s.charAt(end))) & mask;
                if (!set.add(num)) {
                    repeated.add(s.substring(start, end + 1));
                }
            }
            return new ArrayList<>(repeated);
        }
    }
}
