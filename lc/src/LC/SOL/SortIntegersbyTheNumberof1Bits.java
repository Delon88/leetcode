package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;


public class SortIntegersbyTheNumberof1Bits {
    class Solution {
        public int[] sortByBits(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int x : arr)
                list.add(x);
            Collections.sort(list, (a, b) -> {
                int t1 = Integer.bitCount(a);
                int t2 = Integer.bitCount(b);
                if (t1 == t2)
                    return a - b;
                else
                    return t1 - t2;
            });

            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }
}
