package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinPath {
    static class Solution {
        public List<Integer> cheapestJump(int[] A, int B) {
            int n = A.length;
            int[] cost = new int[n], prev = new int[n], len = new int[n];
            Arrays.fill(cost, Integer.MAX_VALUE);
            Arrays.fill(prev, -1);
            cost[0] = 0;
            for ( int i = 0 ; i < n ; i++) {
                if ( A[i] == -1 ) continue;
                for ( int j = Math.max(0, i - B); j < i; j++) {
                    if (A[j] == -1) continue;
                    int c = cost[j] + A[i];
                    if ( c <  cost[i] || (cost[i] == c && len[j] + 1 > len[i])) {
                        cost[i] = c;
                        prev[i] = j;
                        len[i] = len[j] + 1;
                    }
                }
            }
            List<Integer> path = new ArrayList<>();
            for ( int i = n - 1; i >= 0 ; i = prev[i] ) path.add(i + 1);
            Collections.reverse(path);
            return path.get(0) != 1 ? new ArrayList<>(): path;
        }
    }

    public static void main(String[] args) {
        int[] A = {0,0,0,0,0,0};
        System.out.println(new Solution().cheapestJump(A, 3));
    }
}
