package LC.SOL;

import LC.DS.TreeNode;

public class ClosestBinarySearchTreeValue {
    class Solution {
        public int closestValue(TreeNode root, double target) {
            if ( root == null  ) return -1;
            int closet = root.val;
            while ( root != null ) {
                if ( Math.abs(root.val - target) < Math.abs(closet - target)) { closet = root.val;}
                root = root.val < target ? root.right : root.left;
            }
            return closet;
        }
    }
}
