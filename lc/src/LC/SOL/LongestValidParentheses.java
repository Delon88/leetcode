package LC.SOL;

import java.util.Stack;

public class LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for ( int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if ( c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(' ) {
                    int left = stack.pop();
                    if ( stack.isEmpty()) { max = i + 1 ;}
                    else {
                        max = Math.max( i - stack.peek() , max);
                    }
                } else {
                    stack.push(i);
                }
            }
            return max;
        }
    }
}
