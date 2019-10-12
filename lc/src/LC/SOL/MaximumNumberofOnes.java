package LC.SOL;

import java.util.Arrays;

public class MaximumNumberofOnes {
    class Solution {
        public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
            int M = sideLength * sideLength;
            if (maxOnes >= M) return width * height;
            int[] res = new int[M];
            for (int i = 0; i < sideLength; i++) {
                for (int j = 0; j < sideLength; j++) {
                    res[i * sideLength + j] += ((width - i - 1) / sideLength + 1) * ((height - j - 1)/ sideLength + 1);
                }
            }
            Arrays.sort(res);
            int sum = 0;
            for (int i = res.length - 1, j = 0; j < maxOnes; j++, i--) {
                sum += res[i];
            }
            return sum;
        }
    }

}
