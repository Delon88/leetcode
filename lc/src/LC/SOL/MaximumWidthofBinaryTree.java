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
            q.offer(new Node(root, 0));
            while ( !q.isEmpty()) {
                int size = q.size();
                List<Integer> tmpIndex = new ArrayList<>();
                for ( int i = 0 ; i < size ; i++) {
                    Node node = q.poll();
                    tmpIndex.add(node.wIndex);
                    if ( node.node.left != null ) q.offer(new Node(node.node.left , node.wIndex -1));
                    if ( node.node.right != null ) q.offer(new Node(node.node.right , node.wIndex +1));
                }
                if ( tmpIndex.size() != 1) {
                    with = Math.max(with, tmpIndex.get(tmpIndex.size() - 1) - tmpIndex.get(0));
                }
            }
            return with;
        }

        class Node {
            TreeNode node;
            int wIndex;

            public Node(TreeNode node, int wIndex) {
                this.node = node;
                this.wIndex = wIndex;
            }
        }
    }
}
