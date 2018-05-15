package LC.SOL;

import LC.DS.TreeNode;

public class InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if ( root == null ) return root;
            TreeNode left  = invertTree(root.right);
            TreeNode right  = invertTree(root.left);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
