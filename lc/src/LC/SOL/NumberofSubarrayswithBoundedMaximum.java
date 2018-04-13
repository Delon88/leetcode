package LC.SOL;

public class NumberofSubarrayswithBoundedMaximum {
    static class Solution {
        public int numSubarrayBoundedMax(int[] A, int L, int R) {

            int ret = 0, start = 0 , end = 0 , count = 0;
            for ( ; end < A.length; end++ ) {
                if ( A[end] >= L && A[end] <= R) {
                    count = end - start + 1;
                    ret+= count;
                } else if ( A[end] < L ) {
                    ret += count;
                } else {
                    count = 0;
                    start = end + 1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] A = {2,1,4,3};
        System.out.println(new Solution().numSubarrayBoundedMax(A, 2, 3));
    }


}
