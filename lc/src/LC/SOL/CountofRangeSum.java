package LC.SOL;

public class CountofRangeSum {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int[] bit = new int[nums.length + 1];
        }

        void update(int[] id, int i, int value) {
            while (i < id.length) {
                id[i] += value;
                i += (i & -i);
            }
        }

        int getSum(int[] id, int i) {
            int sum = 0;
            while ( i > 0 ) {
                sum += id[i];
                i -= ( i & -i);
            }
            return sum;
        }
    }
}
