package LC.SOL;

import LC.DS.TreeNode;

public class LowestCommonAncestorofDeepestLeaves {
    class Solution {

        class Pair {
            TreeNode node;
            int d;

            public Pair(TreeNode node, int d) {
                this.node = node;
                this.d = d;
            }
        }

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root, 0).node;
        }

        Pair dfs(TreeNode node, int d) {
            if (node == null) return new Pair(null, d);
            Pair l = dfs(node.left, d + 1);
            Pair r = dfs(node.right, d + 1);
            if ( l.d == r.d) {
                return new Pair(node, l.d);
            } else {
                return l.d > r.d ? l : r;
            }
        }
    }
}
