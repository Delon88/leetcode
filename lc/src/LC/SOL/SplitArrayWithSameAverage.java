package LC.SOL;

import java.util.HashSet;

public class SplitArrayWithSameAverage {
    class Solution {
        public boolean splitArraySameAverage(int[] A) {
            int sum = 0;
            for (int n : A) sum += n;
            int lenA = A.length, half = lenA / 2;
            HashSet<Integer>[] knap = new HashSet[half + 1];
            for (int i = 0; i < knap.length; i++) {
                knap[i] = new HashSet<>();
            }
            knap[0].add(0);

            for (int n : A) {
                for (int i = half; i >= 1 ; i--) {
                    for ( Integer knapSum : knap[i - 1]) {
                        int nextSum = n + knapSum;
                        if (  sum * i  == nextSum * lenA ) return true;
                        knap[i].add(nextSum);
                    }
                }
            }

            return false;
        }
    }
}
