package LC.SOL;

import LC.DS.TreeNode;

public class LeafSimilarTrees {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            StringBuilder b1 = new StringBuilder();
            StringBuilder b2 = new StringBuilder();
            preOrder(root1, b1);
            preOrder(root2, b2);
            return b1.toString().equals(b2.toString());
        }

        void preOrder(TreeNode root, StringBuilder b) {
            if ( root == null ) return;
            if ( root.left == null && root.right == null ) {
                b.append(root.val).append(',');
            }
            preOrder(root.left, b);
            preOrder(root.right, b);
        }
    }
}
