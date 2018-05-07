package LC.SOL;

import LC.DS.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while ( root != null ) {
                stack.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if ( node.right != null) {
                TreeNode cur = node.right;
                while ( cur != null ) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            return node.val;
        }
    }
}
