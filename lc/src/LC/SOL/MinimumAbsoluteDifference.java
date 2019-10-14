package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            if (arr.length < 2) return new ArrayList<>();
            Arrays.sort(arr);
            int min = arr[1] - arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                min = Math.min(arr[i + 1] - arr[i], min);
            }
            List<List<Integer>> ret = new ArrayList<>();
            for ( int i = 0 ; i < arr.length - 1; i++) {
                if ( arr[i + 1]  - arr[i] == min) ret.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            return ret;
        }
    }
}
