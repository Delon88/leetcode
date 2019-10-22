package LC.SOL;

import LC.DS.TreeNode;

public class SumRoottoLeafNumbers {
    class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        public int sum(TreeNode n, int s) {
            if (n == null) return 0;
            int newSum = s * 10 + n.val;
            if (n.right == null && n.left == null) return newSum;
            return sum(n.left, newSum) + sum(n.right, newSum);
        }
    }
}
