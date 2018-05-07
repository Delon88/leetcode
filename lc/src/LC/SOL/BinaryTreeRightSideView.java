package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if( root == null) return ret;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                TreeNode last = null;
                for ( int i = 0 ; i < size ; i++){
                    last = q.poll();
                    if ( last.left != null) { q.offer(last.left);}
                    if ( last.right != null ) {q.offer(last.right);}
                }
                ret.add(last.val);
            }
            return ret;
        }
    }
}
