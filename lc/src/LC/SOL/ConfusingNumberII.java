package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {
    class Solution {
        Map<Integer, Integer> map;
        int count;
        int[] nums = {0, 1, 6, 8, 9};
        int N;

        public int confusingNumberII(int N) {
            map = new HashMap<>();
            map.put(6, 9);
            map.put(9, 6);
            map.put(0, 0);
            map.put(1, 1);
            map.put(8, 8);
            count = 0;
            this.N = N;
            dfs(0);
            return count;
        }

        void dfs(long start) {
            if (start > N) return;
            if (isConfuse(start)) count++;
            for (int i = start == 0 ? 1 : 0; i < 5; i++) {
                dfs(start * 10 + nums[i]);
            }
        }

        boolean isConfuse(long n) {
            long ret = 0, x = n;
            while (x > 0) {
                ret = ret * 10 + map.get((int) x % 10);
                x /= 10;
            }
            return ret != n;
        }
    }
}
