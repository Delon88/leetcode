package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class LeastOperatorstoExpressNumber {
    class Solution {
        public int leastOpsExpressTarget(int x, int target) {
            //  target = a0 + a1 * x^1 + a2 * x^2 ...
            List<Integer> rl = new ArrayList<>();
            while (target > 0) {
                rl.add(target % x);
                target /= x;
            }
            int n = rl.size();
            // 6
            // 6,  10 - 4,
            // 86
            // 80 + 6
            // 80 + 10 - 6
            // 100 - 20 + 6
            // 100 - 20 + 10 + 6
            int pos = rl.get(0) * 2, neg = (x - rl.get(0)) * 2;
            for (int i = 1; i < n; i++) {
                int nPos = Math.min(rl.get(i) * i + pos, rl.get(i) * i + i + neg);
                int nNeg = Math.min((x - rl.get(i)) * i + pos, (x - rl.get(i) - 1) * i + neg);
                pos = nPos;
                neg = nNeg;
            }
            return Math.min(pos - 1, n + neg - 1);
        }
    }
}
