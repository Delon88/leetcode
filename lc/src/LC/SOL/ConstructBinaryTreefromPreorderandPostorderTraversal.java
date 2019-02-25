package LC.SOL;

import LC.DS.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            Stack<TreeNode> s = new Stack<>();
            TreeNode root = new TreeNode(pre[0]);
            s.push(root);
            for (int i = 1, j = 0; i < pre.length; i++) {
                TreeNode node = new TreeNode(pre[i]);
                while (s.peek().val == post[j]) {
                    s.pop();
                    j++;
                }
                if (s.peek().left == null) s.peek().left = node;
                else s.peek().right = node;
                s.add(node);
            }
            return root;
        }
    }
}
