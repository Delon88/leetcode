package LC.SOL;

public class SumofSquareNumbers {
    class Solution {
        public boolean judgeSquareSum(int c) {
            if (c < 0) return false;
            int left = 0, right = (int) Math.sqrt(c);
            while (left <= right) {
                int tmp = left * left + right * right;
                if ( tmp == c ) return true;
                else if ( tmp < c ) { left++;}
                else { right--;}
            }
            return false;
        }
    }
}
