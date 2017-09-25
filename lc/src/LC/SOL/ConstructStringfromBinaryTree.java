package LC.SOL;

import LC.DS.TreeNode;

public class ConstructStringfromBinaryTree {
    class Solution {
        public String tree2str(TreeNode t) {
            if ( t == null ) return "";
            String ret = t.val + "";
            String left = tree2str(t.left);
            String right = tree2str(t.right);
            if ( "".equals(left) && "".equals(right)) return ret;
            if ( "".equals(left) && !"".equals(right)) return ret + "()" + "(" + right + ")";
            if ( !"".equals(left) && "".equals(right)) return ret + "(" +left + ")";
            return ret + "(" + left + ")" + "(" + right + ")";
        }
    }
}
