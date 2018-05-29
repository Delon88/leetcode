package LC.SOL;

import java.util.regex.Pattern;

public class PowerofFour {
    class Solution {
        Pattern p = Pattern.compile("10*");
        public boolean isPowerOfFour(int num) {
            return p.matcher(Integer.toString(num, 4)).matches();
        }
    }
}
