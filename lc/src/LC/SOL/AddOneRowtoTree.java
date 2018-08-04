package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if ( root == null || d < 0 ) return root;
            if ( d == 1 ) {
                TreeNode node = new TreeNode(v);
                node.left = root;
                return node;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            for ( int i = 1; i < d - 1 ; i++) {
                int size = q.size();
                for ( int j = 0 ; j < size ; j++) {
                    TreeNode node = q.poll();
                    if ( node.left != null) q.offer(node.left);
                    if ( node.right != null) q.offer(node.right);
                }
            }
            while ( !q.isEmpty()) {
                TreeNode node = q.poll();
                TreeNode t = node.left;
                node.left = new TreeNode(v);
                node.left.left = t;
                t = node.right;
                node.right = new TreeNode(v);
                node.right.right = t;
            }
            return root;
        }
    }
}
