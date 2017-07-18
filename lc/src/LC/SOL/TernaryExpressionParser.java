package LC.SOL;

import java.util.Stack;

public class TernaryExpressionParser {
    public class Solution {
        public String parseTernary(String expression) {
            Stack<Character> stack = new Stack<>();
            for (int i = expression.length() - 1; i >= 0; i--) {
                char c = expression.charAt(i);
                if (!stack.isEmpty() && stack.peek() == '?') {
                    stack.pop();
                    char first = stack.pop();
                    stack.pop();
                    char second = stack.pop();
                    if (c == 'T') {
                        stack.push(first);
                    } else {
                        stack.push(second);
                    }
                } else {
                    stack.push(c);
                }
            }
            return String.valueOf(stack.peek());
        }
    }
}
