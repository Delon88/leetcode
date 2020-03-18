package LC.SOL;

import LC.DS.TreeNode;

import java.util.Stack;

public class RecoveraTreeFromPreorderTraversal {
    class Solution {
        public TreeNode recoverFromPreorder(String S) {
            int depth = 0, num = 0;
            Stack<TreeNode> st = new Stack<>();
            for (int i = 0; i < S.length(); ) {
                for (depth = 0; i < S.length() && S.charAt(i) == '-'; i++) {
                    depth++;
                }
                for (num = 0; i < S.length() && S.charAt(i) != '-'; i++) {
                    num = num * 10 + (S.charAt(i) - '0');
                }
                while (st.size() > depth) {
                    st.pop();
                }
                TreeNode node = new TreeNode(num);
                if (!st.isEmpty()) {
                    if (st.peek().left == null) {
                        st.peek().left = node;
                    } else {
                        st.peek().right = node;
                    }
                }
                st.push(node);
            }
            while (st.size() > 1) st.pop();
            return st.peek();
        }
    }
}
