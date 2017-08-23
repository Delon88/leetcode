package LC.SOL;

import LC.DS.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreefromString {
    class Solution {
        public TreeNode str2tree(String s) {
            Stack<TreeNode> stack = new Stack<>();
            int num = 0;
            for (int i = 0; i < s.length(); i++) {

                if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                    boolean neg = false;
                    if (s.charAt(i) == '-') {
                        neg = true;
                        i++;
                    }
                    num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + (s.charAt(i) - '0');
                        i++;
                    }
                    TreeNode node = new TreeNode(neg ? -num : num);
                    if (!stack.isEmpty()) {
                        if (stack.peek().left == null) stack.peek().left = node;
                        else if (stack.peek().right == null) stack.peek().right = node;
                    }
                    stack.push(node);
                    i--;
                } else if (s.charAt(i) == ')') {
                    stack.pop();
                }
            }
            return stack.isEmpty() ? null : stack.peek();
        }
    }
}
