package LC.SOL;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwapForLongestRepeatedCharacterSubstring {
    class Solution {
        class Pair {
            char c; int f;
            public Pair(char c , int f) {
                this.c = c; this.f = f;
            }
        }
        public int maxRepOpt1(String text) {
            Map<Character,Integer> map = new HashMap<>();
            List<Pair> list = new ArrayList<>();
            for ( int i = 0 ; i < text.length();) {
                char c = text.charAt(i);
                int f = 0;
                while ( i < text.length() && c == text.charAt(i)) {
                    f++;i++;
                }
                list.add(new Pair(c , f));
                map.put(c , map.getOrDefault(c , 0) + f);
            }
            int max = 0 ;
            for ( int i =  0 ; i < list.size() ; i++) {
                Pair p = list.get(i);
                max = Math.max(Math.min(p.f + 1 , map.get(p.c)), max);
                if ( i < list.size() - 2) {
                    if ( list.get(i + 1).f == 1 && list.get(i + 2).c == p.c) {
                        max = Math.max(max, Math.min( list.get(i).f + list.get(i + 2).f + 1 , map.get(p.c)));
                    }
                }
            }
            return max;
        }
    }
}
