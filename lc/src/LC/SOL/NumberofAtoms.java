package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by nanhong on 3/24/2018.
 */
public class NumberofAtoms {
    class Solution {
        public String countOfAtoms(String formula) {
            Map<String, Integer> map = new HashMap<>();
            Stack<Map<String, Integer>> stack = new Stack<>();
            int i = 0, n = formula.length();
            while (i < n) {
                char c = formula.charAt(i);
                if (Character.isLetter(c)) {
                    // parse atom
                    StringBuilder b = new StringBuilder();
                    b.append(c);
                    i++;
                    while (i < n && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))) {
                        b.append(formula.charAt(i));
                        i++;
                    }
                    String atom = b.toString();
                    int num = 0;
                    while (i < n && Character.isDigit(formula.charAt(i))) {
                        num = num * 10 + (formula.charAt(i) - '0');
                        i++;
                    }
                    num = num == 0 ? 1 : num;
                    map.put(atom, map.getOrDefault(atom, 0) + num);
                } else if (c == '(') {
                    i++;
                    stack.push(map);
                    map = new HashMap<>();
                } else if (c == ')') {
                    i++;
                    int num = 0;
                    if (i < n && Character.isDigit(formula.charAt(i))) {
                        while (i < n && Character.isDigit(formula.charAt(i))) {
                            num = num * 10 + (formula.charAt(i) - '0');
                            i++;
                        }
                    }
                    num = num == 0 ? 1 : num;
                    // times the map.
                    for (Map.Entry<String, Integer> e : map.entrySet()) {
                        map.put(e.getKey(), e.getValue() * num);
                    }
                    // merge with top map in stack.
                    if (!stack.isEmpty()) {
                        Map<String, Integer> top = stack.pop();
                        for (Map.Entry<String, Integer> e : top.entrySet()) {
                            map.put(e.getKey(), map.getOrDefault(e.getKey(), 0) + e.getValue());
                        }
                    }
                } else {
                    i++;
                }
            }

            StringBuilder b = new StringBuilder();
            TreeMap<String, Integer> tree = new TreeMap<>(map);
            for (Map.Entry<String, Integer> e : tree.entrySet()) {
                b.append(e.getKey()).append(e.getValue() == 1 ? "" : Integer.toString(e.getValue()));
            }
            return b.toString();
        }
    }
}
