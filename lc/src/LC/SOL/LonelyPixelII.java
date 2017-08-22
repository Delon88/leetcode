package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelII {
    public class Solution {
        public int findBlackPixel(char[][] picture, int N) {
            Map<String, Integer> map = new HashMap<>();
            int m = picture.length, n = picture[0].length;
            int[] colCount = new int[n];
            for (int i = 0; i < picture.length; i++) {
                int rowCount = 0;
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        colCount[j]++;
                        rowCount++;
                    }
                }
                if (rowCount == N) {
                    String rowString = new String(picture[i]);
                    map.put(rowString, map.getOrDefault(rowString, 0) + 1);
                }
            }

            int ret = 0;
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == N) {
                    for (int j = 0; j < e.getKey().length(); j++) {
                        if (e.getKey().charAt(j) == 'B' && colCount[j] == N) ret += N;
                    }
                }
            }
            return ret;
        }
    }
}
