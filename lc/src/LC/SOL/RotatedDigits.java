package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class RotatedDigits {
    class Solution {
        Map<Character, Character> map = new HashMap<>();

        {
            map.put('0', '0');
            map.put('1', '1');
            map.put('8', '8');
            map.put('2', '5');
            map.put('5', '2');
            map.put('6', '9');
            map.put('9', '6');
        }

        public int rotatedDigits(int N) {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                String n = Integer.toString(i);
                StringBuilder rotate = new StringBuilder();
                for (int j = 0; j < n.length(); j++) {
                    if (!map.containsKey(n.charAt(j))) break;
                    rotate.append(map.get(n.charAt(j)));
                }
                if (rotate.length() == n.length() && !rotate.toString().equals(n)) count++;
            }
            return count;
        }
    }
}
