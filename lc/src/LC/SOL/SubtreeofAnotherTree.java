package LC.SOL;

import LC.DS.TreeNode;

public class SubtreeofAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) return false;
            if (isSame(s, t)) return true;
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean isSame(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) return false;
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }
    }
}
