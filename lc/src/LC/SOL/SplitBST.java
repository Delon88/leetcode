package LC.SOL;

import LC.DS.TreeNode;

public class SplitBST {
    class Solution {

        public TreeNode[] splitBST(TreeNode root, int V) {
            TreeNode[] ret = {null, root};
            if (root == null) return ret;
            if ( root.val > V) {
                ret[1] = root;
                TreeNode[] tmp = splitBST(root.left, V);
                root.left = tmp[1];
                ret[0] = tmp[0];
            } else {
                ret[0] = root;
                TreeNode[] tmp = splitBST(root.right, V);
                root.right = tmp[0];
                ret[1] = tmp[1];
            }
            return ret;
        }
    }
}
