package LC.SOL;

import java.util.TreeMap;

public class HandofStraights {
    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for ( int i = 0 ; i < hand.length ; i++) map.put(hand[i] , map.getOrDefault(hand[i] , 0) + 1);
            for ( int k : map.keySet()) {
                if ( map.get(k) > 0 ) {
                    for ( int i = W  - 1 ; i >= 0 ; i--) {
                        if ( map.getOrDefault(i + k , 0) < map.get(k)) return false;
                        map.put( i + k , map.get(i + k) - map.get(k));
                    }
                }
            }
            return true;
        }
    }

}
