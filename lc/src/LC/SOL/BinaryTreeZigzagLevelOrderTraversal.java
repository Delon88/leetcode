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
                int size = q.size();
                List<Integer> tmp = new ArrayList<>();
                for ( int i = 0 ;i  < size ; i++) {
                    TreeNode node = q.poll();
                    tmp.add(node.val);
                    if ( node.left != null ) {q.offer(node.left);}
                    if ( node.right != null) {q.offer(node.right);}
                }
                if ( reverse ) {
                    Collections.reverse(tmp);
                }
                ret.add(tmp);
                reverse = !reverse;
            }
            return ret;
        }
    }
}
