package LC.SOL;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0 , j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while ( i <= j ) {
            int qI  = quad(a , b , c , nums[i]);
            int qJ = quad(a , b , c , nums[j]);
            if ( a >= 0 ) {
                if ( qI >= qJ ) {
                    sorted[index--] = qI; i++;
                } else {
                    sorted[index--] = qJ; j--;
                }
            } else {
                if ( qI >= qJ) {
                    sorted[index++] = qJ; j--;
                } else {
                    sorted[index++] = qI; i++;
                }
            }
        }
        return sorted;
    }

    int quad(int a , int b , int c , int x) {
        return a * x * x + b * x + c;
    }

}
