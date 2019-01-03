package LC.SOL;

import java.util.TreeMap;

public class CarFleet {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            TreeMap<Integer, Double> map = new TreeMap<>();
            for (int i = 0; i < position.length; i++) {
                map.put(target - position[i], (double) (target - position[i]) / speed[i]);
            }
            int ret = 0 ; double curTime = 0;
            for (double time : map.values()) {
                if ( time > curTime ) {
                    curTime = time;
                    ret++;
                }
            }
            return ret;
        }
    }
}
