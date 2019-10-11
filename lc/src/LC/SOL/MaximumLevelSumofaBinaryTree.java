package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
    class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int x = 0, max = Integer.MIN_VALUE;
            int l = 1;
            while ( !q.isEmpty()) {
                int tmp = 0;
                for ( int size = q.size(); size > 0 ; size--) {
                    TreeNode node = q.poll();
                    tmp += node.val;
                    if ( node.left != null) q.offer(node.left);
                    if ( node.right != null) q.offer(node.right);
                }
                if( tmp > max) { max = tmp; x = l;}
                l++;
            }
            return x;
        }
    }
}
