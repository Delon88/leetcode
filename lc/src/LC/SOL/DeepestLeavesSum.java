package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if ( root == null ) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int ret = 0;
            while ( !q.isEmpty()) {
                int sum = 0;
                for ( int size = q.size(); size > 0 ; size--) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if ( node.left != null ) q.offer(node.left);
                    if ( node.right != null ) q.offer(node.right);
                }
                ret = sum;
            }
            return ret;
        }
    }
}
