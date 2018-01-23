package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class ClosestLeafinaBinaryTree {
    class Solution {

        Map<Integer, List<TreeNode>> graph;

        TreeNode target;

        public int findClosestLeaf(TreeNode root, int k) {
            graph = new HashMap<>();
            traverse(root, k);
            Set<Integer> v = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if ( node.left == null && node.right == null) return node.val;
                    for (TreeNode nei : graph.get(node.val)) {
                        if (!v.contains(nei.val)) q.add(nei);
                    }
                    v.add(node.val);
                }
            }
            return -1;
        }

        void traverse(TreeNode node, int k) {
            if (node == null) return;
            if (node.val == k) target = node;

            if (node.left != null) {
                addEdge(node.val, node.left);
                addEdge(node.left.val, node);
            }
            if (node.right != null) {
                addEdge(node.val, node.right);
                addEdge(node.right.val, node);
            }
            traverse(node.left, k);
            traverse(node.right, k);
        }

        void addEdge(int s, TreeNode d) {
            if (!graph.containsKey(s)) graph.put(s, new ArrayList<>());
            graph.get(s).add(d);
        }
    }
}
