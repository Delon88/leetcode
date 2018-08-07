package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int start = 0 , end = arr.length - k;
            while ( start < end ) {
                int mid = start + ( end - start) /2;
                if ( Math.abs(x - arr[mid]) <= Math.abs( x - arr[mid + k])) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            List<Integer> ret = new ArrayList<>();
            for (int i = start; i < start + k; i++) {
                ret.add(arr[i]);
            }
            return ret;
        }
    }
}
