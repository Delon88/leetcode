package LC.SOL;


public class MaximumEqualFrequency {
    class Solution {
        public int maxEqualFreq(int[] A) {
            int[] count = new int[100001], freq = new int[100001];
            int maxF = 0, ret = 0;
            for (int i = 0; i < A.length; i++) {
                int num = A[i];
                count[num]++;
                freq[count[num] - 1]--;
                freq[count[num]]++;
                maxF = Math.max(maxF, count[num]);
                if (maxF == 1 || maxF * freq[maxF] == i || (maxF - 1) * (freq[maxF - 1]) + maxF == i + 1) {
                    ret = i + 1;
                }
            }
            return ret;
        }
    }
}
