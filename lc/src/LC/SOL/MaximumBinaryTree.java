package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class MaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            LinkedList<TreeNode> ll = new LinkedList<>();
            for ( int  n : nums ) {
                TreeNode cur = new TreeNode(n);
                while ( !ll.isEmpty() && ll.peekLast().val < cur.val) {
                    cur.left = ll.removeLast();
                }
                if ( !ll.isEmpty() ) {
                    ll.peekLast().right = cur;
                }
                ll.addLast(cur);
            }
            return ll.peekFirst();
        }
    }
}
