package LC.SOL;

import LC.DS.TreeNode;

public class CountUnivalueSubtrees {
    class Solution {

        int count;
        public int countUnivalSubtrees(TreeNode root) {
            count = 0;
            if ( root == null ) return 0;
            solve(root);
            return count;
        }

        boolean solve(TreeNode root) {
            if ( root == null ) return true;
            boolean left = solve(root.left);
            boolean right = solve(root.right);
            if ( left && right) {
                if ( root.left != null && root.val != root.left.val ) return false;
                if ( root.right != null && root.val != root.right.val) return false;
                count++;
                return true;
            }
            return false;
        }
    }
}
