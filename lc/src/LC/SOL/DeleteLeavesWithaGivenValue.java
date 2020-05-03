package LC.SOL;

import LC.DS.TreeNode;

public class DeleteLeavesWithaGivenValue {
    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if ( root == null ) return null;
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if ( root.left == null && root.right == null ) return root.val == target ? null: root;
            return root;
        }
    }
}
