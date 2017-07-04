package LC.SOL;

/**
 * Created by nanhong on 11/27/2016.
 */
public class GuessNumberHigherorLower {
    static class Solution extends GuessGame {
        public int guessNumber(int n) {
            long start = 1, end = n;
            while (start <= end) {
                int mid = (int) ((start + end) / 2);
                int guess = guess(mid);
                if (guess == 0) return mid;
                else if (guess == 1) start = mid + 1;
                else end = mid - 1;
            }
            return -1;
        }
    }

    static class GuessGame {
        int guess(int num) {
            return 1;
        }
    }
}
