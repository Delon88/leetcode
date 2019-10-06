package LC.SOL;

public class NumberofDaysinaMonth {
    class Solution {
        private final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int numberOfDays(int Y, int M) {
            if (M == 2 && Y % 4 == 0 && Y % 100 != 0 || Y % 400 == 0) return 29;
            return days[M];
        }
    }
}
