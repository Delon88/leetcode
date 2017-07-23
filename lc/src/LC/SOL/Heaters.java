package LC.SOL;

import java.util.Arrays;

public class Heaters {
    public class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int i = 0, j = 0;
            int ret = 0;
            while (  i < houses.length ) {
                // find nearest heater
                while ( j < heaters.length - 1 && Math.abs( houses[i] - heaters[j] ) >=
                        Math.abs(houses[i] - heaters[j + 1])) {
                    j++;
                }
                ret = Math.max( ret , Math.abs(houses[i] - heaters[j]));
                i++;
            }
            return ret;
        }
    }


}
