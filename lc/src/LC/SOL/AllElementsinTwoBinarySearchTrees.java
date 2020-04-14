package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsinTwoBinarySearchTrees {
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            BSTIterator b1 = new BSTIterator(root1);
            BSTIterator b2 = new BSTIterator(root2);
            List<Integer> ret = new ArrayList<>();
            while (b1.hasNext() && b2.hasNext()) {
                if (b1.peek() < b2.peek()) {
                    ret.add(b1.next());
                } else {
                    ret.add(b2.next());
                }
            }
            BSTIterator remain = b1.hasNext() ? b1 : b2;
            while (remain.hasNext()) ret.add(remain.next());
            return ret;
        }

        class BSTIterator {
            Stack<TreeNode> s = new Stack<>();

            public BSTIterator(TreeNode root) {
                while (root != null) {
                    s.push(root);
                    root = root.left;
                }
            }

            public int peek() {
                return s.peek().val;
            }

            public boolean hasNext() {
                return !s.isEmpty();
            }

            public int next() {
                TreeNode n = s.pop();
                // key concept: push the right Node, then push all of its left branch
                if (n.right != null) {
                    s.push(n.right);
                    TreeNode r = n.right;
                    while (r.left != null) {
                        s.push(r.left);
                        r = r.left;
                    }
                }
                return n.val;
            }
        }
    }
}
