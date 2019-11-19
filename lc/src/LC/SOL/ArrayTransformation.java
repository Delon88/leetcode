package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTransformation {
    class Solution {
        public List<Integer> transformArray(int[] arr) {
            int n = arr.length;
            int[] ret = new int[n];
            while (!Arrays.equals(ret, arr)) {
                ret = arr.clone();
                for (int i = 1; i < n - 1; i++) {
                    if ( ret[i - 1] < ret[i] && ret[i] > ret[i + 1]) {
                        arr[i]--;
                    } else if ( ret[i - 1] > ret[i] && ret[i] < ret[i + 1]) {
                        arr[i]++;
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            for ( int a : arr) list.add(a);
            return list;
        }
    }
}
