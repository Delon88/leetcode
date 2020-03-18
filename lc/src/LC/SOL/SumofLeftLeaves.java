package LC.SOL;

import LC.DS.TreeNode;

/**
 * Created by nanhong on 1/15/2017.
 */
public class SumofLeftLeaves {
    public class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if ( root == null) return 0;
            if ( root.left != null && root.left.left == null && root.left.right == null ) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
