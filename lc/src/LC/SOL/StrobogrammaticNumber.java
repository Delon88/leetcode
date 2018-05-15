package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    class Solution {
         Map<Character, Character> m = new HashMap<>();

         {
            m.put('1', '1');
            m.put('6', '9');
            m.put('9', '6');
            m.put('8', '8');
            m.put('0', '0');
        }

        public boolean isStrobogrammatic(String num) {
            if ( num == null || num.length() == 0 ) return false;
            int  n = num.length();
            int start = 0 , end = n - 1;
            while ( start <= end ) {
                if ( !m.containsKey(num.charAt(start)) || m.get(num.charAt(start)) != num.charAt(end)) return false;
                start++; end--;
            }
            return true;
        }
    }
}
