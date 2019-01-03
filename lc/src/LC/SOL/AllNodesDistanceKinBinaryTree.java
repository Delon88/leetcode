package LC.SOL;

import LC.DS.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    class Solution {
        Map<TreeNode, List<TreeNode>> graph;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            graph = new HashMap<>();
            List<Integer> ret = new ArrayList<>();
            if (root == null || K < 0) return ret;
            inOrder(root, null);
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(target);
            Set<TreeNode> v = new HashSet<>();
            v.add(target);
            while (!q.isEmpty()) {
                if (K == 0) {
                    for (int size = q.size(); size > 0; size--) ret.add(q.poll().val);
                    return ret;
                }
                for (int size = q.size(); size > 0; size--) {
                    TreeNode node = q.poll();
                    for (TreeNode nei : graph.get(node)) {
                        if (v.add(nei)) {
                            q.offer(nei);
                        }
                    }
                }
                K--;
            }
            return ret;
        }

        void inOrder(TreeNode node, TreeNode parent) {
            if (node == null) return;
            if (!graph.containsKey(node)) {
                graph.put(node, new ArrayList<>());
                if (parent != null) {
                    graph.get(node).add(parent);
                    graph.get(parent).add(node);
                }
                inOrder(node.left, node);
                inOrder(node.right, node);
            }
        }
    }
}
