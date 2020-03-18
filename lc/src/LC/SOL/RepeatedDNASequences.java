package LC.SOL;

import java.util.*;

public class RepeatedDNASequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            int mask = 0xFFFFF;
            Map<Character,Integer> map = new HashMap<>();
            map.put('A', 0); map.put('C', 1); map.put('G',2); map.put('T', 3);
            Set<Integer> nums = new HashSet<>();
            Set<String> seq = new HashSet<>();
            int n = 0;
            for ( int i = 0 ; i < s.length() ; i++) {
                n = ((n << 2 ) | ( map.get(s.charAt(i)))) & mask;
                if ( i >= 9 && !nums.add(n)) {
                    seq.add(s.substring(i - 9, i + 1));
                }
            }
            return new ArrayList<>(seq);
        }
    }
}
