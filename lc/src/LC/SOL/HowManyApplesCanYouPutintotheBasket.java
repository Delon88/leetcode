package LC.SOL;

import java.util.Arrays;

public class HowManyApplesCanYouPutintotheBasket {
    class Solution {
        public int maxNumberOfApples(int[] arr) {
            Arrays.sort(arr);
            int count = 0, sum = 0;
            for (int i: arr) {
                sum += i;
                if ( sum > 5000 ) break;
                count++;
            }
            return count;
        }
    }
}
