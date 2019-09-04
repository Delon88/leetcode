package LC.SOL;

import LC.DS.TreeNode;

public class UnivaluedBinaryTree {
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if ( root == null ) return true;
            boolean ret = true;
            if ( root.left != null ) ret = ret && root.left.val == root.val && isUnivalTree(root.left);
            if ( root.right != null) ret = ret && root.right.val == root.val && isUnivalTree(root.right);
            return ret;
        }
    }
}
