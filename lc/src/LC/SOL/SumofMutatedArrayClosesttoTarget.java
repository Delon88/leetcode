package LC.SOL;

public class SumofMutatedArrayClosesttoTarget {
    class Solution {
        public int findBestValue(int[] arr, int target) {
            int start = 0, end = 0;
            for (int i : arr) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }

        }
    }
}