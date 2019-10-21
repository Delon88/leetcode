package LC.contest;

import java.util.HashMap;
import java.util.Map;

public class Test {
    int n;

    public int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (Character c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int l = 0, r = 0, min = s.length();
        n = s.length();
        while (r < n) {
            char rc = s.charAt(r++);
            map.put(rc, map.get(rc) - 1);
            while (isBal(map)) {
                min = Math.min(min, r - l);
                if ( l < n ) {
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) + 1);
                } else {break;}
            }
        }
        return min;
    }

    private boolean isBal(Map<Character, Integer> map) {
        for (Integer i : map.values())
            if (i > n / 4) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test().balancedString("WQWRQQQW"));
    }
}
