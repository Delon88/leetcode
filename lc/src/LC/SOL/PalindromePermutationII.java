package LC.SOL;

import java.util.*;

public class PalindromePermutationII {
    class Solution {

        String mid;

        public List<String> generatePalindromes(String s) {
            // check if is palindrome
            Set<Character> set = new HashSet<>();
            for ( int i = 0 ;  i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( !set.add(c)) { set.remove(c);}
            }
            List<String> ret = new ArrayList<>();
            if ( set.size() > 1) return ret;
            Map<Character,Integer> map = new HashMap<>();
            for ( int i = 0 ;i < s.length() ; i++) {
                char c =s.charAt(i);
                map.put(c , map.getOrDefault(c , 0) + 1);
            }
            StringBuilder b = new StringBuilder();
            mid = set.size() == 1 ? set.iterator().next() + "" : "";
            for ( Map.Entry<Character,Integer> e : map.entrySet()) {
                for ( int i = 0 ; i < e.getValue() / 2 ; i++) {
                    b.append(e.getKey());
                }
            }
            char[] cands = b.toString().toCharArray();
            perm(b.toString().toCharArray(), new boolean[cands.length], new StringBuilder(), ret);
            return ret;
        }


        void perm(char[] cands, boolean[] used, StringBuilder tmp, List<String> ret) {
            if (  cands.length == tmp.length() ) {
                ret.add(tmp.toString() + mid + tmp.reverse().toString());
                tmp.reverse();
                return;
            }
            for ( int i = 0 ;i < cands.length ; i++) {
                if ( !used[i]) {
                    used[i] = true;
                    tmp.append(cands[i]);
                    perm(cands, used, tmp, ret);
                    used[i] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                    while ( i < cands.length - 1 && cands[i] == cands[i + 1]) {
                        i++;
                    }
                }
            }
        }
    }
}
