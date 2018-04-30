package LC.SOL;

import LC.DS.TreeNode;

public class ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean isBST(TreeNode root, long min , long max) {
            if ( root == null ) return true;
            if ( root.val <= min || root.val >= max) return false;
            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
        }
    }
}
