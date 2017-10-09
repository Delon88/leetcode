package LC.SOL;

import java.util.Arrays;

public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            int len = tasks.length;
            for ( char t : tasks) {
                count[ t - 'A']++;
            }

            Arrays.sort(count);
            int i = 25;
            while ( i >= 0 && count[i] == count[25]) i--;
            int framesize = ( count[25] - 1) * ( n + 1) + 25 - i;
            return Math.max(framesize, len);
        }
    }
}
