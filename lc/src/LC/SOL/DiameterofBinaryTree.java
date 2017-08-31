package LC.SOL;

import LC.DS.TreeNode;

public class DiameterofBinaryTree {
    class Solution {

        int dia = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dia = 0;
            solve(root);
            return dia;
        }

        int solve(TreeNode root) {
            if (root == null) return 0;
            int left = solve(root.left);
            int right = solve(root.right);
            if (left + right > dia) dia = left + right;
            return Math.max(left, right) + 1;
        }
    }
}
