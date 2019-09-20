package LC.SOL;

import LC.DS.TreeNode;

public class BinarySearchTreetoGreaterSumTree {
    class Solution {
        int sum;

        public TreeNode bstToGst(TreeNode root) {
            int sum = 0;
            solve(root);
            return root;
        }

        void solve(TreeNode node) {
            if ( node == null ) return;
            solve(node.right);
            sum += node.val;
            node.val = sum;
            solve(node.left);
        }
    }
}
