package LC.SOL;

import java.util.Arrays;

public class SuperWashingMachines {
    class Solution {
        public int findMinMoves(int[] machines) {

            long sum = 0;
            for (int n : machines) {
                sum += n;
            }
            if (sum % machines.length != 0) return -1;

            int[] diff = new int[machines.length];

            int target = (int) (sum / machines.length);
            for (int i = 0; i < machines.length; i++) {
                diff[i] = machines[i] - target;
            }
            System.out.println(Arrays.toString(diff));
            int ret = 0;
            for (int i = 0; i < machines.length - 1; i++) {
                ret += Math.abs(diff[i]);
                diff[i + 1] = diff[i] + diff[i + 1];
            }
            return ret;
        }
    }
}
