package LC.SOL;

import LC.DS.TreeNode;

public class InorderSuccessorinBST {

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            // find first node greater than p.val
            TreeNode cur = root, succ = null;
            while ( cur != null ) {
                if ( cur.val > p.val) {
                    succ = cur;
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            return succ;
        }
    }
}
