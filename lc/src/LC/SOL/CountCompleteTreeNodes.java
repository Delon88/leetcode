package LC.SOL;

import LC.DS.TreeNode;

public class CountCompleteTreeNodes {
    class Solution {
        public int countNodes(TreeNode root) {
            int h = height(root);
            if ( h < 0 ) return 0;
            int rightH = height(root.right);
            if ( rightH == h - 1) {
                return ( 1 << h ) + countNodes(root.right);
            } else {
                return ( 1 << h - 1) + countNodes(root.left);
            }
        }

        int height(TreeNode root) {
            int count = -1;
            while ( root != null ) {
                root = root.left;
                count++;
            }
            return count;
        }
    }
}
