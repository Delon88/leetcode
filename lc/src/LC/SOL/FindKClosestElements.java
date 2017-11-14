package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int start = 0, end = arr.length - k;
            while (start < end) {
                int mid = (start + end) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    start = mid + 1;
                } else {
                    end = mid;
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
