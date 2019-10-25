package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeUpsideDown {
    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if( root == null ) return root;
            TreeNode cur = root, parentRight = null, parent = null;
            while ( cur != null  ) {
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                cur.right = parent;
                cur.left = parentRight;
                parent = cur;
                parentRight = right;
                cur = left;
            }
            return parent;
        }
    }
}
