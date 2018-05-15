package LC.SOL;

import LC.DS.TreeNode;

public class KthSmallestElementinaBST {
    class Solution {
        int count;
        int ret;
        int k;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.count = 0;
            this.ret = 0;
            inOrder(root);
            return ret;
        }

        void inOrder(TreeNode root) {
            if ( root == null ) return;
            inOrder(root.left);
            count++;
            if ( count == k ) {ret = root.val;return;}
            inOrder(root.right);
        }


    }
}
