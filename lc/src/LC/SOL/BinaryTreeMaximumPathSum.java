package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeMaximumPathSum {
    class Solution {
        int max;
        public int maxPathSum(TreeNode root) {
            if ( root == null ) return 0;
            max = root.val;
            solve(root);
            return max;
        }

        int solve(TreeNode root) {
            if ( root == null ) return 0;
            int left = solve(root.left);
            int right = solve(root.right);
            if ( left + right + root.val > max ) {
                max = left + right + root.val;
            }
            int ret = Math.max( left, right ) + root.val;
            return ret > 0 ? ret : 0;
        }
    }
}
