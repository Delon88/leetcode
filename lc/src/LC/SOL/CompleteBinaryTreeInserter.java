package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeInserter {
    class CBTInserter {

        List<TreeNode> tree;

        public CBTInserter(TreeNode root) {
            tree = new ArrayList<>();
            tree.add(root);
            for (int i = 0; i < tree.size(); i++) {
                TreeNode node = tree.get(i);
                if ( node.left != null) tree.add(node.left);
                if ( node.right != null) tree.add(node.right);
            }
        }

        public int insert(int v) {
            int size = tree.size();
            TreeNode node = new TreeNode(v);
            tree.add(node);
            if ( size % 2 == 1 ) {
                tree.get((size - 1) / 2).left = node;
            } else {
                tree.get((size - 1) / 2).right = node;
            }
            return tree.get((size - 1) / 2).val;
        }

        public TreeNode get_root() {
            return tree.get(0);
        }
    }
}
