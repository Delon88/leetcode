package LC.SOL;

import LC.DS.TreeNode;

public class ConvertBSTtoGreaterTree {
    class Solution {
        int curSum = 0;
        public TreeNode convertBST(TreeNode root) {
            curSum = 0;
            revPostOrder(root);
            return root;
        }

        void revPostOrder(TreeNode node) {
            if ( node == null ) return;
            revPostOrder(node.right);
            node.val += curSum;
            curSum = node.val;
            revPostOrder(node.left);
        }
    }
}
