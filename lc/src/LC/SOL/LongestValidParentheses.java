package LC.SOL;

import java.util.Stack;

public class LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = i + 1;
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                } else {
                    stack.push(i);
                }
            }
            return max;
        }
    }

    class Solution1 {
        public int longestValidParentheses(String s) {
            char[] S = s.toCharArray();
            int[] V = new int[S.length];
            int open = 0;
            int max = 0;
            for (int i = 0; i < S.length; i++) {
                if (S[i] == '(') open++;
                if (S[i] == ')' && open > 0) {
                    // matches found
                    V[i] = 2 + V[i - 1];
                    // add matches from previous
                    if (i - V[i] > 0)
                        V[i] += V[i - V[i]];
                    open--;
                }
                if (V[i] > max) max = V[i];
            }
            return max;
        }
    }
}
