package LC.SOL;

public class PourWater {
    class Solution {
        public int[] pourWater(int[] heights, int V, int K) {
            if (K < 0 || K >= heights.length) return heights;
            for (int i = 0; i < V; i++) {
                // try left
                int index = K;
                for (int j = K - 1; j >= 0; j--) {
                    if (heights[j] > heights[index]) {
                        break;
                    } else if (heights[j] < heights[index]) {
                        index = j;
                    }
                }
                if (index != K) {
                    heights[index]++;
                    continue;
                }
                for (int j = K + 1; j < heights.length; j++) {
                    if (heights[j] > heights[index]) {
                        break;
                    } else if (heights[j] < heights[index]) {
                        index = j;
                    }
                }
                heights[index]++;
            }
            return heights;
        }
    }
}
