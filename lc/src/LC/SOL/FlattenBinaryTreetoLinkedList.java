package LC.SOL;

import LC.DS.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    class Solution {

        TreeNode prev;

        public void flatten(TreeNode root) {
            prev = null;
            flat(root);
        }

        void flat(TreeNode root) {
            if ( root == null) return;
            flat(root.right);
            flat(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

}
