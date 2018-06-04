package LC.SOL;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nanhong on 12/11/2016.
 */
public class ShuffleanArray {
    public class Solution {
        int[] nums;
        Random rn;
        public Solution(int[] nums) {
            this.nums = nums;
            rn= new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if ( nums == null ) return null;
            int[] copy = nums.clone();
            int n = copy.length;
            for ( int i = 0; i < n; i++) {
                int r = i + (rn.nextInt(n - i));
                int tmp = copy[i];
                copy[i] = copy[r];
                copy[r] = tmp;
            }
            return copy;
        }
    }

}
