package LC.SOL;

import java.math.BigInteger;
import java.util.Stack;

public class BasicCalculatorIII {
    class Solution {
        BigInteger
        public int calculate(String s) {
            int l1 = 0, o1 = 1;
            int l2 = 1, o2 = 1;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + (s.charAt(i) - '0');
                        i++;
                    }
                    i--;
                    l2 = (o2 == 1 ? l2 * num : l2 / num);
                } else if (c == '(') {
                    stack.push(l1);stack.push(o1);stack.push(l2);stack.push(o2);
                    l1 = 0; o1 = 1;
                    l2 = 1; o2 = 1;
                } else if ( c == ')') {
                    int num = l1 + o1 * l2;
                    o2  = stack.pop(); l2 = stack.pop(); o1 = stack.pop(); l1 = stack.pop();
                    l2 = ( o2 == 1? l2 * num : l2 / num);
                } if ( c == '*' || c == '/') {
                    o2 = (c == '*' ? 1: -1);
                } else if ( c == '-' || c == '+') {
                    if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                        o1 = -1;
                        continue;
                    }
                    l1 = l1 + o1 * l2;
                    o1 = ( c  == '+' ? 1: -1);
                    l2 = 1 ; o2 = 1;
                }
            }
            return ( l1 + o1* l2);
        }
    }
}
