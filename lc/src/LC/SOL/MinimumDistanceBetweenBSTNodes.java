package LC.SOL;

import LC.DS.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    class Solution {

        int min = Integer.MAX_VALUE;

        TreeNode prev = null;

        public int minDiffInBST(TreeNode root) {
            inOrder(root);
            return min;
        }

        void inOrder(TreeNode root) {
            if ( root == null ) return;
            inOrder(root.left);
            if ( prev != null) {
                int diff = root.val - prev.val;
                min = Math.min(diff, min);
            }
            prev = root;
            inOrder(root.right);
        }
    }
}
