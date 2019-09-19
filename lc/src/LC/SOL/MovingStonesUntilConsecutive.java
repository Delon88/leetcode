package LC.SOL;

import java.util.Arrays;

public class MovingStonesUntilConsecutive {
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] stones = new int[]{a, b, c};
            Arrays.sort(stones);
            if (stones[2] - stones[0] == 2) return new int[]{0, 0};
            int max = stones[2] - stones[0] - 2;
            int min = Math.min(stones[1] - stones[0], stones[2] - stones[1]) <= 2 ? 1 : 2;
            return new int[]{min, max};
        }
    }
}
