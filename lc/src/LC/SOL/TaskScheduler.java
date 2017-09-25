package LC.SOL;

public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            int n = tasks.length;
            for ( char t : tasks) {
                count[ t - 'A']++;
            }

            for ( int i = 0 ; i < n ; i++) {
                
            }

        }


    }
}
