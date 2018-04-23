package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    class Solution {

        Map<Character, Integer> base = new HashMap<>();

        {
            base.put('I', 1);
            base.put('V', 5);
            base.put('X', 10);
            base.put('L', 50);
            base.put('C', 100);
            base.put('D', 500);
            base.put('M', 1000);
        }

        public int romanToInt(String s) {
            int sum = 0;
            int i = s.length() - 1;
            while (i > 0) {
                if (base.get(s.charAt(i)) <= base.get(s.charAt(i - 1))) {
                    sum += base.get(s.charAt(i));
                    i--;
                } else {
                    sum += base.get(s.charAt(i)) - base.get(s.charAt(i - 1));
                    i -= 2;
                }
            }
            if ( i == 0 ) sum += base.get(s.charAt(i));
            return sum;
        }
    }
}
