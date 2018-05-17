package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    class Solution {
        int max;

        public int longestConsecutive(TreeNode root) {
            if ( root == null ) return 0;
            max = 0;
            preorder(root, 0 , root.val);
            return max;
        }

        void preorder(TreeNode root, int len , int target) {
            if ( root == null) return;
            if ( root.val == target) len++;
            else len = 1;
            max = Math.max(len,max);
            preorder(root.left, len, root.val + 1);
            preorder(root.right, len, root.val + 1);
        }
    }
}
