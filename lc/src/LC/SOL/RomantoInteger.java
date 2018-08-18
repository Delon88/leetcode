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
            if (s == null || s.length() == 0) return 0;
            int sum = base.get(s.charAt(s.length() - 1));
            for ( int i = s.length() - 2 ; i >= 0  ; i--) {
                int first = base.get(s.charAt(i));
                int second = base.get(s.charAt(i + 1));
                if ( first < second) {
                    sum -= first;
                } else {
                    sum += first;
                }
            }
            return sum;
        }
    }
}
