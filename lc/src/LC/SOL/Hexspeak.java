package LC.SOL;

import java.util.HashMap;
import java.util.Map;

public class Hexspeak {
    class Solution {
        public String toHexspeak(String num) {

            long n = Long.parseLong(num);
            Map<Integer, Character> map = new HashMap<>();
            map.put(0, 'O');
            map.put(1, 'I');
            map.put(10, 'A');
            map.put(11, 'B');
            map.put(12, 'C');
            map.put(13, 'D');
            map.put(14, 'E');
            map.put(15, 'F');
            String ans = "";
            while (n > 0) {
                int rem = (int) (n % 16);
                if (!map.containsKey(rem)) return "ERROR";
                n = n / 16;
                ans = map.get(rem) + ans;
            }

            return ans;
        }
    }
}
