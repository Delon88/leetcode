package LC.SOL;

import LC.DS.TreeNode;

public class SecondMinimumNodeInaBinaryTree {
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            if ( root == null ) return -1;
            int minVal = minVal(root, root.val);
            return minVal;
        }

        int minVal(TreeNode node, int first) {
            if ( node == null ) return -1;
            if ( node.val != first) return node.val;
            int left = minVal(node.left , first);
            int right = minVal(node.right , first);
            if ( left == -1 ) return right;
            if ( right == -1) return left;
            return Math.min(left , right);
        }
    }
}
