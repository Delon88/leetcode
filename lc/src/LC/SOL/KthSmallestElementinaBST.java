package LC.SOL;

import LC.DS.TreeNode;

public class KthSmallestElementinaBST {
    class Solution {
        int ret;
        int k;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.ret = 0;
            inOrder(root);
            return ret;
        }

        void inOrder(TreeNode root) {
            if ( root == null ) return;
            inOrder(root.left);
            k--;
            if ( k == 0 ) {ret = root.val;return;}
            inOrder(root.right);
        }
    }
}
