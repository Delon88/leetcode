package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (q.peek() != null) {
                TreeNode node = q.poll();
                q.offer(node.left);
                q.offer(node.right);
            }
            while (!q.isEmpty() && q.peek() == null) {
                q.poll();
            }
            return q.isEmpty();
        }
    }
}
