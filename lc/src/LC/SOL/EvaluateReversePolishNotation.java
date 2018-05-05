package LC.SOL;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            String ops = "-+*/";
            for ( String t : tokens) {
                if ( ops.contains(t)) {
                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    stack.push(apply(o1, o2, t));
                } else {
                    stack.push(Integer.parseInt(t));
                }
            }
            return stack.peek();
        }

        int apply(int o1, int o2, String op) {
            if ( op.equals("+")) {
                return o1 + o2;
            } else if ( op.equals("-")) {
                return o1 - o2;
            } else if ( op.equals("*")) {
                return o1 * o2;
            } else {
                return o1 / o2;
            }
        }
    }
}
