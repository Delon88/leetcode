package LC.SOL;

public class PourWater {
    class Solution {
        public int[] pourWater(int[] heights, int V, int K) {
            if ( K < 0 || K >= heights.length) return heights;
            for (int i = 0; i < V; i++) {
                // try left
                int left = K - 1;
                int leftMin = heights[K];
                int minIndex = -1;
                while ( left >= 0 && heights[left] <= heights[K]) {
                    if ( heights[left] < leftMin) {
                        minIndex = left;
                        leftMin = heights[left];
                    }
                    left--;
                }
                if ( leftMin < heights[K]) {
                    heights[minIndex]++;
                } else {
                    // look for right
                    minIndex = -1;
                    int rightMin = heights[K];
                    int right = K + 1;
                    while ( right < heights.length && heights[right] <= heights[K]) {
                        if ( heights[right] < rightMin) {
                            minIndex = right;
                            rightMin = heights[right];
                        }
                        right++;
                    }
                    if ( rightMin < heights[K]) {
                        heights[minIndex]++;
                    } else {
                        heights[K]++;
                    }
                }
            }
            return heights;
        }
    }
}
