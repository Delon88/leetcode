package LC.SOL;

import java.util.regex.Pattern;

public class PowerofThree {
    class Solution {
        Pattern pattern = Pattern.compile("10*");

        public boolean isPowerOfThree(int n) {
            return pattern.matcher(Integer.toString(n, 3)).matches();
        }
    }
}
