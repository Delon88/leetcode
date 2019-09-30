package LC.SOL;

public class DistributeCandiestoPeople {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] ret = new int[num_people];
            for ( int give = 0 ; candies > 0 ; candies -= give) {
                ret[ give % num_people] += Math.min(candies, ++give);
            }
            return ret;
        }
    }
}
