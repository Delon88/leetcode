package LC.SOL;


import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    class Solution {
        public int[] numsSameConsecDiff(int N, int K) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < 10; i++) cur.add(i);
            for (int i = 2; i <= N; i++) {
                List<Integer> next = new ArrayList<>();
                for (int j = 0; j < cur.size(); j++) {
                    int x = cur.get(j), y = x % 10;
                    if (x > 0 && (y + K) < 10) {
                        next.add(x * 10 + y + K);
                    }
                    if (x > 0 && K > 0 && y - K >= 0) {
                        next.add(x * 10 + y - K);
                    }
                }
                cur = next;
            }
            return cur.stream().mapToInt(j -> j).toArray();
        }
    }
}
