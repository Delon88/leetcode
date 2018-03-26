package LC.SOL;

import java.util.*;

public class ParseLispExpression {
    static class Solution {
//        Input: (add 1 2)
//        Output: 3
//
//        Input: (mult 3 (add 2 3))
//        Output: 15
//
//        Input: (let x 2 (mult x 5))
//        Output: 10
//
//        Input: (let x 2 (mult x (let x 3 y 4 (add x y))))
//        Output: 14
//        Explanation: In the expression (add x y), when checking for the value of the variable x,
//        we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.
//        Since x = 3 is found first, the value of x is 3.
//
//        Input: (let x 3 x 2 x)
//        Output: 2
//        Explanation: Assignment in let statements is processed sequentially.
//
//                Input: (let x 1 y 2 x (add x y) (add x y))
//        Output: 5
//        Explanation: The first (add x y) evaluates as 3, and is assigned to x.
//                The second (add x y) evaluates as 3+2 = 5.
//
//        Input: (let x 2 (add (let x 3 (let x 4 x)) x))
//        Output: 6
//        Explanation: Even though (let x 4 x) has a deeper scope, it is outside the context
//        of the final x in the add-expression.  That final x will equal 2.
//
//        Input: (let a1 3 b2 (add a1 1) b2)
//        Output 4
//        Explanation: Variable names can contain digits after the first character.

        public int evaluate(String expression) {
            Set<String> operators = new HashSet<>(Arrays.asList("add", "mult", "let"));
            Stack<Map<String,Integer>> scope = new Stack<>();
            int i = 0 , n = expression.length();
            while ( i < n ) {
                char c = expression.charAt(i);
                if ( c == '(') {

                }
            }
        }
    }
}
