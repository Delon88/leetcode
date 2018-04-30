package LC.SOL;

import LC.DS.TreeNode;

public class MaximumDepthofBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if ( root == null ) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
