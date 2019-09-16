package LC.SOL;

import LC.DS.TreeNode;

public class ConstructBinarySearchTreefromPreorderTraversal {
    class Solution {

        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            i = 0;
            return build(preorder, Integer.MAX_VALUE);
        }

        TreeNode build(int[] A, int max) {
            if (i == A.length || A[i] > max) return null;
            TreeNode root = new TreeNode(A[i++]);
            root.left = build(A, root.val);
            root.right = build(A, max);
            return root;
        }
    }

    class Solution1 {
        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            i = 0;
            return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        TreeNode build(int[] A, int min, int max) {
            if (i == A.length || A[i] > max || A[i] < min) return null;
            TreeNode root = new TreeNode(A[i++]);
            root.left = build(A, min, root.val);
            root.right = build(A, root.val, max);
            return root;
        }
    }
}
