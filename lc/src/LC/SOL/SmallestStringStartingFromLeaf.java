package LC.SOL;

import LC.DS.TreeNode;

public class SmallestStringStartingFromLeaf {
    class Solution {

        StringBuilder b;

        String min;
        public String smallestFromLeaf(TreeNode root) {
            b = new StringBuilder();
            min = null;
            dfs(root);
            return min;
        }

        void dfs(TreeNode node) {
            if (node == null) return;
            b.append((char)(node.val + 'a'));
            if ( node.left == null && node.right == null ) {
                String str = b.reverse().toString();
                b.reverse();
                if ( min == null || str.compareTo(min) < 0 ) min = str;
            }
            dfs(node.left); dfs(node.right);
            b.deleteCharAt(b.length() - 1);
        }
    }
}
