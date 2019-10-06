package LC.SOL;

import LC.DS.TreeNode;

public class MaximumAverageSubtree {
    class Solution {

        double max = Double.MIN_VALUE;
        public double maximumAverageSubtree(TreeNode root) {
            max = Double.MIN_VALUE;
            solve(root);
            return max;
        }

        int[] solve(TreeNode root) {
            if (root == null) return new int[]{0, 0};
            int[] l = solve(root.left);
            int[] r = solve(root.right);
            int[] ret = new int[]{l[0] + root.val + r[0], l[1] + 1 + r[1]};
            max = Math.max(max, (double) ret[0] / ret[1]);
            return ret;
        }
    }
}
