package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class CanPlaceFlowers {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            List<Integer> consecZero = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    count++;
                }
            }
        }
    }
}
