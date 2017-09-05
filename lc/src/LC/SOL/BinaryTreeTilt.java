package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeTilt {
    class Solution {
        int tit = 0;

        public int findTilt(TreeNode root) {
            find(root);
            return tit;
        }

        int find(TreeNode root) {
            if (root == null) return 0;
            int left = find(root.left);
            int right = find(root.right);
            tit += Math.abs(left - right);
            return root.val + left + right;
        }
    }
}
