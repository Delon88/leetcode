package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinPath {
    static class Solution {
        public List<Integer> cheapestJump(int[] A, int B) {
            List<Integer> ret = new ArrayList<>();
            int n = A.length;
            if (A.length <= 0 || A[0] < 0 || B <= 0 || A[A.length - 1] < 0) return ret;
            int[] cost = new int[n];
            int[] prev = new int[n];
            int[] len = new int[n];
            Arrays.fill(cost, Integer.MAX_VALUE);
            Arrays.fill(prev , -1);
            cost[0] = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] < 0) {
                    cost[i] = -1;
                    continue;
                }
                for (int j = Math.max(0, i - B); j < i ; j++) {
                    if (cost[j] != -1) {
                        int c = cost[j] + A[j];
                        if (cost[i] > c || (cost[i] == c && len[i] < len[j] + 1)) {
                            cost[i] = cost[j] + A[j];
                            prev[i] = j;
                            len[i] = len[j] + 1;
                        }
                    }
                }
                if (cost[i] == Integer.MAX_VALUE) return ret;
            }
            int index = A.length - 1;
            while (index >= 0) {
                ret.add(index + 1);
                index = prev[index];
            }
            Collections.reverse(ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] A = {0,0,0,0,0,0};
        System.out.println(new Solution().cheapestJump(A, 3));
    }
}
