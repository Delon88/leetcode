package LC.SOL;

import LC.DS.TreeNode;

public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if ( root == null) return true;
            return isSym(root.left , root.right);
        }

        boolean isSym(TreeNode p, TreeNode q) {
            if ( p == null && q == null) return true;
            if ( p == null || q == null ) return false;
            return p.val == q.val && isSym(p.left , q.right) && isSym(p.right, q.left);
        }
    }
}
