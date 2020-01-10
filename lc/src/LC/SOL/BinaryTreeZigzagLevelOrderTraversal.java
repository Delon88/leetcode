package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( root == null ) return ret;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            boolean reverse = false;
            while ( !q.isEmpty()) {
                LinkedList<Integer> tmp = new LinkedList<>();
                for ( int i = q.size() ; i > 0 ; i--) {
                    TreeNode node = q.poll();
                    if ( reverse) tmp.addFirst(node.val); else tmp.add(node.val);
                    if ( node.left != null ) {q.offer(node.left);}
                    if ( node.right != null) {q.offer(node.right);}
                }
                ret.add(tmp);
                reverse = !reverse;
            }
            return ret;
        }
    }
}
