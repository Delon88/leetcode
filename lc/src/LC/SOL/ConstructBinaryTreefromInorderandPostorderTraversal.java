package LC.SOL;

import LC.DS.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0 , inorder.length - 1, postorder, 0 , postorder.length - 1);
        }

        TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd) {
            if ( inStart > inEnd) {
                return null;
            }
            int rootValue = postorder[pEnd];
            int rootIndex = -1;
            for ( int i = inStart ; i <= inEnd ; i++) {
                if ( inorder[i] == rootValue ) {
                    rootIndex = i;
                    break;
                }
            }
            int leftLen = rootIndex - inStart;
            TreeNode left = build(inorder, inStart, rootIndex -1, postorder, pStart, pStart + leftLen -1 );
            TreeNode right = build(inorder, rootIndex + 1 , inEnd, postorder, pStart + leftLen, pEnd - 1);
            TreeNode root = new TreeNode(rootValue);
            root.left = left ;
            root.right =right;
            return root;
        }
    }
}
