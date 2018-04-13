package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarRGBColor {
    class Solution {
        public String similarRGB(String color) {
            StringBuilder b = new StringBuilder();
            b.append("#");
            for (int i = 1; i < color.length(); i += 2) {
                int c = Integer.parseInt(color.charAt(i) + "" + color.charAt(i), 16);
                if (color.charAt(i) == color.charAt(i + 1)) {
                    b.append(color.charAt(i) + "" + color.charAt(i));
                } else {
                    int c1 = Integer.parseInt(color.charAt(i) + "" , 16);
                    int c2 = Integer.parseInt(color.charAt(i + 1) + "" , 16);
                    b.append(closetColor(c1, c2));
                }
            }
            return b.toString();
        }

        String closetColor(int c1, int c2) {
            int cc = c1 * 16 + c2;
            int[] cands = {(c1 - 1) * 16 + c1 - 1, c1 * 16 + c1, (c1 + 1) * 16 + c1 + 1};
            int diff = Integer.MAX_VALUE;
            int ret = 0;
            for (int cand : cands) {
                if (Math.abs(cand - cc) < diff && cand >= 0 && cand < 16 * 16 + 16) {
                    ret = cand;
                    diff = Math.abs(cand - cc);
                }
            }
            if ( ret == 0 ) return "00";
            return Integer.toString(ret, 16);
        }
    }
}
