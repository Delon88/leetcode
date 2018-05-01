package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( root == null ) return ret;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while ( !q.isEmpty()) {
                int size = q.size();
                List<Integer> tmp = new ArrayList<>();
                for ( int i =0 ; i < size ; i++) {
                    TreeNode node = q.poll();
                    tmp.add(node.val);
                    if ( node.left != null ) {q.offer(node.left);}
                    if ( node.right != null) {q.offer(node.right);}
                }
                ret.add(tmp);
            }
            Collections.reverse(ret);
            return ret;
        }
    }
}
