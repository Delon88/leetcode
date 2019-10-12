package LC.SOL;

import java.util.TreeSet;

public class MakeArrayStrictlyIncreasing {
    class Solution {
        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            if ( arr1.length == 1) return 0;
            TreeSet<Integer> set = new TreeSet<>();
            for ( int a : arr2) set.add(a);
            int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        }
    }
}
