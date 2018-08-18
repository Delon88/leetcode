package LC.SOL;

import LC.DS.TreeNode;

public class LongestUnivaluePath {
    class Solution {

        int maxLen;
        public int longestUnivaluePath(TreeNode root) {
            if ( root == null ) return 0;
            maxLen = 0;
            solve(root,  root.val);
            return maxLen;
        }

        int solve(TreeNode node, int parentVal) {
            if ( node == null) return 0;
            int left = solve(node.left, node.val);
            int right = solve(node.right, node.val);
            maxLen = Math.max(maxLen, left + right);
            if ( parentVal == node.val) return Math.max(left ,right) + 1;
            return 0;
        }
    }
}
