package LC.SOL;

import LC.DS.TreeNode;

public class SumofRootToLeafBinaryNumbers {
    class Solution {
        int ret;

        public int sumRootToLeaf(TreeNode root) {
            ret = 0;
            solve(root, 0);
            return ret;
        }

        void solve(TreeNode node, int pv) {
            if ( node == null ) return;
            pv = pv * 2 + node.val;
            if ( node.left == null && node.right == null ) ret+= pv;
            solve(node.left, pv) ; solve( node.right, pv);
        }
    }
}
