package LC.SOL;

import LC.DS.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0  , preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart , int inEnd) {
            if ( inStart > inEnd ) {
                return null;
            }
            int rootValue = preorder[pStart];
            int rootIndex = -1;
            for ( int i = inStart ; i <= inEnd ; i++) {
                if ( inorder[i] == rootValue) {
                    rootIndex = i;
                    break;
                }
            }
            int leftLen = rootIndex - inStart;
            TreeNode root = new TreeNode(rootValue);
            root.left = build(preorder, pStart + 1, pStart + leftLen, inorder, inStart, rootIndex - 1 );
            root.right = build(preorder, pStart + leftLen + 1 , pEnd, inorder, rootIndex + 1 , inEnd);
            return root;
        }
    }
}
