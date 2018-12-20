package LC.SOL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class HandofStraights {
    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            int n = hand.length;
            if (  W <= 0 || n % W != 0 ) return false;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < hand.length; i++) {
                map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
                if ( map.get(hand[i]) > n / W ) return false;
            }
            for (int k : map.keySet()) {
                if (map.get(k) > 0) {
                    for (int i = W - 1; i >= 0; i--) {
                        if (map.getOrDefault(i + k, 0) < map.get(k)) return false;
                        map.put(i + k, map.get(i + k) - map.get(k));
                    }
                }
            }
            return true;
        }
    }

    class Solution1 {
        public boolean isNStraightHand(int[] hand, int W) {
            int n = hand.length;
            if (  W <= 0 || n % W != 0 ) return false;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < hand.length; i++) {
                map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
                if ( map.get(hand[i]) > n / W ) return false;
            }
            int lastNum = -1, opened = 0;
            Queue<Integer> q = new LinkedList<>();
            for ( int k : map.keySet()) {
                if ( opened > 0 && k > lastNum + 1 || opened > map.get(k)) return false;
                q.add(map.get(k) - opened);
                lastNum = k;
                opened = map.get(k);
                if ( q.size() == W) opened -= q.remove();
            }
            return opened == 0;
        }
    }

}
