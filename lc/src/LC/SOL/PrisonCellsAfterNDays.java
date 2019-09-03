package LC.SOL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Map<String, Integer> map = new HashMap<>();
            while (N > 0) {
                map.put(Arrays.toString(cells), N);
                int[] next = new int[8];
                N--;
                for (int i = 1; i < 7; i++) next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
                cells = next;
                if (map.containsKey(Arrays.toString(cells))) {
                    N = N % (map.get(Arrays.toString(cells)) - N);
                }
            }
            return cells;
        }
    }
}
