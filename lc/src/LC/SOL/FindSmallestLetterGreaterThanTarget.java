package LC.SOL;

public class FindSmallestLetterGreaterThanTarget {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            if ( target >= letters[n - 1]) return letters[0];

            int start = 0, end = n - 1, mid = 0;
            while ( start < end ) {
                mid = ( start + end ) / 2;
                if ( letters[mid] > target ) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return letters[start];
        }
    }
}
