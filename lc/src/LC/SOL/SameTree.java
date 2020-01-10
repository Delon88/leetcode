package LC.SOL;

import LC.DS.TreeNode;

public class SameTree {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if ( p == null && q == null ) return true;
            if ( p == null || q == null ) return false;
            return p.val == q.val && isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
        }
    }
}
