package LC.SOL;

import LC.DS.TreeNode;

public class RecoverBinarySearchTree {
    class Solution {

        TreeNode p1, p2, prev;

        public void recoverTree(TreeNode root) {
            p1 = p2 = prev = null;
            inOrder(root);
            int tmp = p1.val;
            p1.val = p2.val;
            p2.val = tmp;
        }

        void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            if (prev != null && prev.val > root.val) {
                if (p1 == null) {
                    p1 = prev;
                    p2 = root;
                } else {
                    p2 = root;
                }
            }
            prev = root;
            inOrder(root.right);
        }
    }
}
