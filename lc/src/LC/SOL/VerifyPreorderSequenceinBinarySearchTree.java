package LC.SOL;


import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {
    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            int index = -1;
            long min = Long.MIN_VALUE;
            for ( int p : preorder) {
                if ( p < min ) return false;
                while ( index >= 0 && p > preorder[index] ) {
                    min = preorder[index--];
                }
                preorder[++index] = p;
            }
            return true;
        }

        public boolean verifyPreorder1(int[] preorder) {
            Stack<Integer> stack = new Stack<>();
            long min = Long.MIN_VALUE;
            for ( int p : preorder ) {
                if ( p < min ) return false;
                while ( !stack.isEmpty() && p > stack.peek()) {
                    min = stack.pop();
                }
                stack.push(p);
            }
            return true;
        }
    }
}
