package LC.SOL;

public class RLEIterator {
    class RLEIterator {

        int index = 0;
        int repeats = 0;
        int[] A;

        public RLEIterator(int[] A) {
            this.A = A;
            repeats = A[0];
        }

        public int next(int n) {
            while ( n > 0 && index < A.length) {
                if ( n > repeats ) {
                    index += 2;
                    n -= repeats;
                    if ( index < A.length ) repeats = A[index];
                } else {
                    repeats -= n;
                    n = 0;
                }
            }
            if ( index >= A.length) return -1;
            return A[index + 1];
        }
    }
}
