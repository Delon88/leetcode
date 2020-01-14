package LC.SOL;

import LC.DS.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsinaContaminatedBinaryTree {
    class FindElements {

        Set<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            pre(root, 0);
        }

        void pre(TreeNode node, int v ) {
            if ( node == null ) return;
            node.val = v;
            set.add(v);
            pre(node.left, 2 * v + 1);
            pre(node.right, 2 * v + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
