package LC.SOL;

import LC.DS.TreeNode;

public class TrimaBinarySearchTree {
    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            return trim(root, L, R);
        }

        TreeNode trim(TreeNode node, int L, int R) {
            if (node == null) return null;
            TreeNode left = trim(node.left, L, R);
            TreeNode right = trim(node.right, L, R);
            if (node.val >= L && node.val <= R) {
                node.left = left;
                node.right = right;
                return node;
            } else if (node.val < L) {
                return right;
            } else {
                return left;
            }
        }
    }
}
