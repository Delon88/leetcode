package LC.SOL;

import LC.DS.TreeNode;

public class SecondMinimumNodeInaBinaryTree {
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null) return -1;
            return findSecondMinValue(root, root.val);
        }


        public int findSecondMinValue(TreeNode root, int min) {
            if (root == null) return -1;
            if (root.val > min) return root.val;
            int leftMin = findSecondMinValue(root.left, min);
            int rightMin = findSecondMinValue(root.right, min);
            return (leftMin == -1 || rightMin == -1) ? Math.max(leftMin, rightMin) : Math.min(leftMin, rightMin);
        }
    }
}
