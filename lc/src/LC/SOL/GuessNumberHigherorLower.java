package LC.SOL;

public class GuessNumberHigherorLower {
    static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int start = 1 , end = n , mid = 0;
            while ( start <= end ) {
                mid = start + ( end - start ) / 2;
                int guess = guess(mid);
                if ( guess == 0 ) return mid;
                else if ( guess == 1 ) start = mid + 1;
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
