package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> ret = new ArrayList<>();
            char[] tmp = s.toCharArray();
            for (int i = 0; i < tmp.length - 1; i++) {
                if (tmp[i] == '+' && tmp[i + 1] == '+') {
                    tmp[i] = '-';
                    tmp[i + 1] = '-';
                    ret.add(new String(tmp));
                    tmp[i] = '+';
                    tmp[i+ 1] = '+';
                }
            }
            return ret;
        }
    }
}
