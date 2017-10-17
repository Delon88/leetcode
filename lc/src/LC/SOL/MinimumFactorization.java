package LC.SOL;


import java.util.ArrayList;
import java.util.List;

public class MinimumFactorization {
    class Solution {
        public int smallestFactorization(int a) {
            if (a < 10) return a;
            List<Integer> list = new ArrayList<>();
            for (int i = 9; i >= 2; i--) {
                while (a % i == 0) {
                    a /= i;
                    list.add(i);
                }
            }
            if (a != 1) return 0;
            long ret = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                ret = ret * 10 + list.get(i);
                if (ret > Integer.MAX_VALUE) return 0;
            }
            return (int) ret;
        }
    }
}
