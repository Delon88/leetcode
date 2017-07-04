package LC.SOL;

import LC.DS.TreeNode;

/**
 * Created by nanhong on 1/15/2017.
 */
public class SumofLeftLeaves {
    public class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ret = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) ret += root.left.val;
                else ret+= sumOfLeftLeaves(root.left);
            }
            ret+= sumOfLeftLeaves(root.right);
            return ret;
        }

    }
}
