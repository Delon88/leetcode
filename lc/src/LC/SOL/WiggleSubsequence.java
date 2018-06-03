package LC.SOL;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if ( nums == null || nums.length == 0 ) return 0;
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        pos[0] = 1;neg[0]= 1;
        for ( int i = 1 ; i< n ;i++) {
            if ( nums[i] > nums[i -1 ] ) {
                pos[i] = neg[i  - 1] + 1;
                neg[i] = neg[i - 1];
            } else if ( nums[i] < nums[i - 1]) {
                neg[i] = pos[i - 1] + 1;
                pos[i] = pos[i - 1];
            } else {
                pos[i] = pos[ i - 1];
                neg[i] = neg[i - 1];
            }
        }
        return Math.max(pos[n - 1] , neg[n- 1]);
    }
}
