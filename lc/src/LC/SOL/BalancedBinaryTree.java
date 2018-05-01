package LC.SOL;

import LC.DS.TreeNode;

public class BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return isBal(root) >= 0;
        }

        int isBal(TreeNode root) {
            if ( root == null) return 0;
            int left = isBal(root.left);
            int right = isBal(root.right);
            if ( left == -1 || right == -1) return -1;
            if ( Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
    }
}
