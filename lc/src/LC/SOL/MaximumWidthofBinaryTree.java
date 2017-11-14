package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int with = 0;
            if (root == null) return 0;
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(root, 1));
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> tmpIndex = new ArrayList<>();
                int l = q.peek().seq;
                int r = l;
                for (int i = 0; i < size; i++) {
                    Node node = q.poll();
                    r = node.seq;
                    if (node.node.left != null) q.offer(new Node(node.node.left, node.seq * 2));
                    if (node.node.right != null) q.offer(new Node(node.node.right, node.seq * 2 + 1));
                }
                with = Math.max( r - l + 1, with);
            }
            return with;
        }

        class Node {
            TreeNode node;
            int seq;

            public Node(TreeNode node, int seq) {
                this.node = node;
                this.seq = seq;
            }
        }
    }
}
