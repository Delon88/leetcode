package LC.SOL;

import LC.DS.TreeNode;

public class MaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if ( nums == null  || nums.length == 0) return null;
            return construct(nums, 0 , nums.length - 1);
        }

        TreeNode  construct(int[] nums, int start, int end) {
            if ( start > end ) {
                return null;
            }

            int maxIndex  = -1;
            int max = Integer.MIN_VALUE;
            for ( int i = start ; i <= end ; i++) {
                if ( max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            TreeNode left = construct(nums, start , maxIndex -1);
            TreeNode right = construct(nums, maxIndex + 1 , end);
            TreeNode root = new TreeNode(max);
            root.left = left; root.right = right;
            return root;
        }
    }
}
