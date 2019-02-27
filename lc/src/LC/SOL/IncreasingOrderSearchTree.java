package LC.SOL;

import LC.DS.TreeNode;

public class IncreasingOrderSearchTree {
    class Solution {

        TreeNode prev;
        TreeNode head;
        public TreeNode increasingBST(TreeNode root) {
            prev =null;
            head = null;
            inOrder(root);
            return head;
        }

        void inOrder(TreeNode node) {
            if ( node == null ) return;
            inOrder(node.left);
            if ( head == null ) {
                head = node;
            } else {
                prev.right = node;
            }
            prev = node;
            node.left = null;
            inOrder(node.right);
        }
    }
}
