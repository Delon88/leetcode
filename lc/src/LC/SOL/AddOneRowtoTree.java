package LC.SOL;

import LC.DS.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (root == null || d <= 0) return root;
            if ( d == 1 ) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = root;
                return newRoot;
            }
            Queue<TreeNode> q = new LinkedList<>();
            int level = 1;
            q.offer(root);
            while (!q.isEmpty() && level != d) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        q.offer(node.right);
                    }

                    if (level == d - 1) {
                        if (node.left != null) {
                            TreeNode tmp = node.left;
                            node.left = new TreeNode(v);
                            node.left.left = tmp;
                        } else {
                            node.left = new TreeNode(v);
                        }
                    }

                    if (level == d - 1) {
                        if (node.right != null) {
                            TreeNode tmp = node.right;
                            node.right = new TreeNode(v);
                            node.right.right = tmp;
                        } else {
                            node.right = new TreeNode(v);
                        }
                    }

                }
                level++;
            }
            return root;
        }
    }
}
