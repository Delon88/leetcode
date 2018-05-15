package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '-' || c == '+' || c == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                    for (Integer o1 : left) {
                        for (Integer o2 : right) {
                            ret.add(apply(o1 , o2 , c));
                        }
                    }
                }
            }
            if ( ret.size() == 0 ) ret.add(Integer.parseInt(input));
            return ret;
        }

        int apply(int o1, int o2, char op) {
            if (op == '-') {
                return o1 - o2;
            } else if (op == '+') {
                return o1 + o2;
            } else {
                return o1 * o2;
            }
        }
    }
}
