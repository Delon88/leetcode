package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for ( int i = 1 ;i <= n ; i++) {
                list.add(i);
            }

            StringBuilder b = new StringBuilder();
            int fact = 1;
            for ( int i  = 2 ; i < n ; i++) {
                fact *= i;
            }
            k--;
            for ( int i = n - 1 ; i > 0 ; i--) {
                int index = k / fact;
                b.append(list.get(index));
                list.remove(index);
                k %= fact;
                fact /= i;
            }
            b.append(list.get(0));
            return b.toString();
        }
    }
}
