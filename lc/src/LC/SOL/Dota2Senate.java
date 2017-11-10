package LC.SOL;

import java.util.TreeSet;

public class Dota2Senate {
    class Solution {
        public String predictPartyVictory(String senate) {
            TreeSet<Integer> r = new TreeSet<>();
            TreeSet<Integer> d = new TreeSet<>();
            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == 'R') {
                    r.add(i);
                } else {
                    d.add(i);
                }
            }



        }
    }
}
