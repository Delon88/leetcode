package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return -1;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            TreeNode first = null;
            while (!q.isEmpty()) {
                int size = q.size();
                first = q.peek();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
            }
            return first.val;
        }
    }
}
