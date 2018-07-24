package LC.SOL;

import java.util.Arrays;

public class MagicalString {
    static class Solution {
        public int magicalString(int n) {
            if ( n <= 0 ) return 0;
            if ( n <= 3 ) return 1;
            int[] arr = new int[n + 1];
            arr[0] = 1; arr[1] = 2; arr[2] = 2;
            int head = 2 , tail = 3, curNum = 1, ret = 1;
            while ( tail < n ) {
                for ( int i = 0 ; i < arr[head] ; i++) {
                    arr[tail] = curNum;
                    if ( curNum == 1 && tail < n ) ret++;
                    tail++;
                }
                curNum = curNum ^ 3;
                head++;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        new Solution().magicalString(3);
    }
}