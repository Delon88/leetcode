package LC.SOL;

public class BinarySubarraysWithSum {
    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            int n = A.length, pSum = 0, ret = 0;
            int[] sum = new int[n + 1];
            sum[0] = 1;
            for (int i : A) {
                pSum += i;
                if (pSum >= S) {
                    ret += sum[pSum - S];
                }
                sum[pSum]++;
            }
            return ret;
        }
    }
}