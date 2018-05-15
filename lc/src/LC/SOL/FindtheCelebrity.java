package LC.SOL;

public class FindtheCelebrity {
    class Solution {
        boolean knows(int a, int b) {
            return true;
        }

        public int findCelebrity(int n) {
            int start = 0, end = n - 1;
            while (start < end) {
                if (knows(start, end)) start++;
                else end--;
            }

            for (int i = 0; i < n; i++) {
                if (i != start) {
                    if ( knows(start , i) || !knows(i , start) ) return -1;
                }
            }
            return start;
        }
    }
}
