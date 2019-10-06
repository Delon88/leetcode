package LC.SOL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {
    class Solution {
        public String alphabetBoardPath(String target) {
            int x = 0, y = 0;
            StringBuilder b = new StringBuilder();
            for (char c : target.toCharArray()) {
                int nx = (c - 'a') % 5, ny = (c - 'a') / 5;
                b.append(String.join("", Collections.nCopies(Math.max(0, y - ny), "U")))
                        .append(String.join("", Collections.nCopies(Math.max(0, nx - x), "R")))
                        .append(String.join("", Collections.nCopies(Math.max(0, x - nx), "L")))
                        .append(String.join("", Collections.nCopies(Math.max(0, ny - y), "D")))
                .append('!');
                x = nx ; y = ny;
            }
            return b.toString();
        }
    }
}
