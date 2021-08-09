package LC.SOL;

import LC.DS.TreeNode;

public class MaximumProductofSplittedBinaryTree {
    class Solution {
        long sum = 0;
        long max = 0;
        public int maxProduct(TreeNode root) {
            sum = 0;max = 0;
            inorder(root);
            postorder(root);
            return (int) (max % 1000000007);
        }

        void inorder(TreeNode root) {
            if ( root == null ) return;
            sum += root.val;
            inorder(root.left);
            inorder(root.right);
        }

        int postorder(TreeNode root) {
            if ( root == null ) return 0;
            int ret = 0;
            int left = postorder(root.left);
            int right = postorder(root.right);
            ret = left + right + root.val;
            if (( sum - ret ) * ret  > max) {
                max = ( sum - ret ) * ret;
            }
            return ret;
        }
    }
}
