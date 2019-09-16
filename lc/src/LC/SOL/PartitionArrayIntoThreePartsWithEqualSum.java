package LC.SOL;

public class PartitionArrayIntoThreePartsWithEqualSum {
    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int a : A) sum += a;
            if (sum % 3 != 0) return false;
            int count = 0, curSum = 0;
            for (int a : A) {
                curSum += a;
                if ( curSum == sum / 3) {count++;curSum = 0;}
            }
            return count > 2;
        }
    }
}
