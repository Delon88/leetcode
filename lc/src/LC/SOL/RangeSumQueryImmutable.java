package LC.SOL;

public class RangeSumQueryImmutable {
    class NumArray {

        int[] cumu;

        public NumArray(int[] nums) {
            cumu = new int[nums.length + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                cumu[i + 1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return cumu[j + 1] - cumu[i];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
