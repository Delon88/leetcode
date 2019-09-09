package LC.SOL;

public class BrokenCalculator {
    class Solution {
        public int brokenCalc(int X, int Y) {
            int op = 0;
            while (Y > X) {
                if (Y % 2 == 1) Y++;
                else Y = Y / 2;
                op++;
            }
            return op + (X - Y);
        }
    }
}
