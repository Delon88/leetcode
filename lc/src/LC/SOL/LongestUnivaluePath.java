package LC.SOL;

import LC.DS.TreeNode;

public class LongestUnivaluePath {
    class Solution {

        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            solve(root);
            return max;
        }

        private int[] solve(TreeNode node) {
            if (node == null) return new int[]{0, 0};
            int[] left = solve(node.left);
            int[] right = solve(node.right);
            int count = 0;

            if (left[1] != 0 && left[0] == node.val) {count += left[1];}
            if (right[1] != 0 && right[0] == node.val) {count += right[1];}
            max = Math.max(max, count);

            int[] ret = {node.val, 1};
            if (left[1] != 0 && left[0] == node.val) ret[1] += left[1];
            if (right[1] != 0 && right[0] == node.val) ret[1] = Math.max(ret[1] , right[1]+ 1);
            return ret;
        }
    }
}
