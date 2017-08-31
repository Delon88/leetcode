package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceII {
    class Solution {

        int max = 0;

        public int longestConsecutive(TreeNode root) {
            solve(root);
            return max;
        }

        public int[] solve(TreeNode node) {
            if (node == null) return new int[]{0, 0};

            int incre = 1, decre = 1;
            if (node.left != null) {
                int[] left = solve(node.left);
                if (node.val == node.left.val + 1) {
                    decre = left[1] + 1;
                } else if (node.val == node.left.val - 1) {
                    incre = left[0] + 1;
                }
            }
            if (node.right != null) {
                int[] right = solve(node.right);
                if (node.val == node.right.val + 1) {
                    decre = Math.max(right[1] + 1, decre);
                } else if (node.val == node.right.val - 1) {
                    incre = Math.max(right[0] + 1, incre);
                }
            }

            max = Math.max(max, incre + decre - 1);
            return new int[]{incre, decre};
        }
    }
}
