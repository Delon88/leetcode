package LC.SOL;

public class RangeSumQueryMutable {
    class NumArray {

        private int[] bit;
        private int[] nums;
        private int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            bit = new int[n + 1];
            for (int i = 0; i < n; i++) {
                updateTree(i, nums[i]);
            }
        }

        void updateTree(int i, int val) {
            i++;
            while (i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }

        void update(int i, int val) {
            updateTree(i, val - nums[i]);
            nums[i] = val;
        }

        int getSum(int i) {
            i++;
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }
            return sum;
        }


        public int sumRange(int i, int j) {
            return getSum(j) - getSum(i - 1);
        }
    }

}
