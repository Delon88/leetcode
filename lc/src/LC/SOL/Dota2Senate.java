package LC.SOL;

import java.util.LinkedList;

public class Dota2Senate {
    class Solution {
        public String predictPartyVictory(String senate) {
            int n = senate.length();
            LinkedList<Integer> r = new LinkedList<>();
            LinkedList<Integer> d = new LinkedList<>();
            for ( int i = 0 ; i < senate.length() ; i++) {
                if ( senate.charAt(i) == 'R') {
                    r.add(i);
                } else {
                    d.add(i);
                }
            }

            while ( !r.isEmpty() && !d.isEmpty()) {
                int rIn = r.pollFirst() , dIn = d.pollFirst();
                if ( rIn < dIn ) {
                    r.add( rIn + n);
                } else {
                    d.add(dIn + n);
                }
            }

            return ( r.size() > d.size()) ? "Radiant" : "Dire";
        }
    }
}
