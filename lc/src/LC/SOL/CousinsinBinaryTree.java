package LC.SOL;

import LC.DS.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CousinsinBinaryTree {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Set<Integer> set = new HashSet<>();
                for (int size = q.size(); size > 0; size--) {
                    TreeNode node = q.poll();
                    set.add(node.val);
                    if ( node.left != null && node.right != null) {
                        if ( (x == node.left.val && y == node.right.val) || ( x == node.right.val && y == node.left.val)) return false;
                    }
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
                if (set.contains(x) && set.contains(y)) return true;
            }
            return false;
        }
    }
}
