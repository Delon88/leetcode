package LC.SOL;

import LC.DS.TreeNode;

public class DistributeCoinsinBinaryTree {
    class Solution {
        int sum = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return sum;
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            sum += Math.abs(left) + Math.abs(right);
            return left + right + root.val - 1;
        }
    }
}
