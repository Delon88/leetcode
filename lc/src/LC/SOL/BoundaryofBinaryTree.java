package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryofBinaryTree {
    class Solution {
        List<Integer> nodes = new ArrayList<>();

        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            nodes.clear();
            if (root == null) return nodes;
            nodes.add(root.val);
            leftBoundary(root.left);
            leaves(root.left);
            leaves(root.right);
            rightBoundary(root.right);
            return nodes;
        }

        void leftBoundary(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return;
            nodes.add(root.val);
            if (root.left == null) leftBoundary(root.right);
            else leftBoundary(root.left);
        }

        void rightBoundary(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return;
            if (root.right == null) rightBoundary(root.left);
            else rightBoundary(root.right);
            nodes.add(root.val);
        }

        void leaves(TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) nodes.add(root.val);
            leaves(root.left);
            leaves(root.right);
        }
    }
}
