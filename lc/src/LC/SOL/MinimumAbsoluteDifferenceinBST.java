package LC.SOL;

import LC.DS.TreeNode;

public class MinimumAbsoluteDifferenceinBST {
    public class Solution {

        int diff = Integer.MAX_VALUE;

        TreeNode prev = null;

        public int getMinimumDifference(TreeNode root) {
            solve(root);
            return diff;
        }

        void solve(TreeNode root) {
            if (root == null) return;
            solve(root.left);
            if (prev != null) {
                diff = Math.min(diff, root.val - prev.val);
            }
            prev = root;
            solve(root.right);
        }
    }
}
