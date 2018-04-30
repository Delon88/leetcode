package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while ( !stack.isEmpty() || cur != null ) {
                if ( cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode node = stack.pop();
                    ret.add(node.val);
                    cur = node.right;
                }
            }
            return ret;
        }
    }
}
