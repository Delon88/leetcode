package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ret = new ArrayList<>();
            if (root == null) return ret;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                double sum = 0.0d;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
                ret.add(sum / size);
            }
            return ret;
        }
    }
}
