package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarRGBColor {

    class Solution {
        String[] rgbs = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};

        public String similarRGB(String color) {
            StringBuilder b = new StringBuilder();
            b.append("#");
            for (int i = 1; i < color.length(); i += 2) {
                String hex = color.substring(i, i + 2);
                String res = "";
                int diff = Integer.MAX_VALUE;
                for (String r : rgbs) {
                    int tmp = Math.abs(Integer.parseInt(hex, 16) - Integer.parseInt(r, 16));
                    if ( tmp < diff ) {
                        res = r;
                        diff = tmp;
                    }
                }
                b.append(res);
            }
            return b.toString();
        }
    }
}
