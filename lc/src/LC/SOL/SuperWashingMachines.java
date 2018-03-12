package LC.SOL;

import java.util.Arrays;

public class SuperWashingMachines {
    class Solution {
        public int findMinMoves(int[] machines) {
            int n = machines.length;
            int sum = 0;
            for (int i : machines) sum += i;
            if (sum % n != 0) return -1;
            int[] diff = new int[n];
            int target = sum / n;
            for (int i = 0; i < machines.length; i++) {
                diff[i] = machines[i] - target;
            }
            int ret = 0;
            int d = 0;
            for (int i = 0; i < n; i++) {
                ret = Math.max(Math.abs(diff[i]), ret);
                d += diff[i];
                ret = Math.max(Math.abs(d), ret);
            }
            return ret;
        }
    }
}
