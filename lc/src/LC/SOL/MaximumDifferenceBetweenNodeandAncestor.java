package LC.SOL;

import LC.DS.TreeNode;

public class MaximumDifferenceBetweenNodeandAncestor {
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return solve(root, root.val, root.val);
        }

        public int solve(TreeNode root, int min, int max) {
            if (root == null) return max - min;
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
            return Math.max(solve(root.left, min, max) , solve(root.right, min, max));
        }
    }
}
