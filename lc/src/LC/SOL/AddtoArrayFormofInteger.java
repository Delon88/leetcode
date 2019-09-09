package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddtoArrayFormofInteger {
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> list = new ArrayList<>();
            for (int i = A.length - 1; i >= 0; i--) {
                int sum = A[i] + K;
                list.add(sum % 10);
                K = sum / 10;
            }
            while ( K > 0 ) {
                list.add( K % 10);
                K /= 10;
            }
            Collections.reverse(list);
            return list;
        }
    }
}
