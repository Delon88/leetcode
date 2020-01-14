package LC.SOL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofBurgerswithNoWasteofIngredients {
    class Solution {
        // ( 2 * x + 4 * y ) = ts
        // 2x + 2y = 2cs
        // 2y = ts - 2cs
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            int twoX = tomatoSlices - 2 * cheeseSlices, x = twoX / 2, y = cheeseSlices - x;
            return twoX >= 0 && twoX % 2 == 0 && y >= 0 ? Arrays.asList(x, y) : Arrays.asList();
        }
    }
}
