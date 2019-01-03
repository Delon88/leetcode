package LC.SOL;

import java.util.Stack;

public class ScoreofParentheses {
    class Solution {
        public int scoreOfParentheses(String S) {
            Stack<Integer> stack = new Stack<>();
            int score = 0;
            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '(') {
                    stack.push(-1);
                } else {
                    int cur = 0;
                    while (stack.peek() != -1) {
                        cur += stack.pop();
                    }
                    stack.pop();
                    stack.push(cur == 0 ? 1 : cur * 2);
                }
            }
            while (!stack.isEmpty()) {
                score += stack.pop();
            }
            return score;
        }
    }

    class Solution1 {
        public int scoreOfParentheses(String S) {
            int layer = 0, ret = 0;
            for ( int i = 0 ; i < S.length() ; i++) {
                if ( S.charAt(i) == '(') layer++; else layer--;
                if ( S.charAt(i) == '(' && S.charAt(i + 1) == ')') ret += 1 << (layer - 1);
            }
            return ret;
        }
    }
}
