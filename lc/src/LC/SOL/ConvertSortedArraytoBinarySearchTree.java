package LC.SOL;

import LC.DS.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if ( nums == null || nums.length == 0) return null;
            return build(nums, 0 , nums.length - 1);
        }

        TreeNode build(int[] nums, int start, int end) {
            if ( start > end) {return null;}
            int mid = start + ( end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, start , mid - 1);
            root.right = build(nums, mid + 1 , end);
            return root;
        }
    }
}
