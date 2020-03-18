package LC.SOL;


import java.io.File;

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int[] count = new int[60];
            int ret = 0;
            for (int t : time) {
                int m = t % 60;
                ret += count[m == 0 ? 0 : 60 - m];
                count[m] += 1;
            }
            return ret;
            File f = new File("");
            f.isFile();
        }
    }
}
