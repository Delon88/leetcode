package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ret = new LinkedList<>();
            if ( root == null ) return ret;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while ( !stack.isEmpty() || cur != null ) {
                if ( cur != null) {
                    stack.push(cur);
                    ret.addFirst(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode node = stack.pop();
                    cur = node.left;
                }
            }
            return ret;
        }
    }
}
