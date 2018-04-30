package LC.SOL;

import LC.DS.TreeNode;

public class RecoverBinarySearchTree {
    class Solution {

        TreeNode p1 ;
        TreeNode p2 ;
        TreeNode prev;
        public void recoverTree(TreeNode root) {
            p1 = null;
            p2 = null;
            prev = null;
            inOrder(root);
            int tmp = p1.val;
            p1.val = p2.val;
            p2.val = tmp;
        }

        void inOrder(TreeNode root) {
            if ( root == null ) return;
            inOrder(root.left);
            if ( prev != null && root.val < prev.val) {
                if ( p1 == null) {
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
