package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            List<List<String>> ret = new ArrayList<>();
            int rows = root == null ? 1 : getHeight(root);
            int cols = (int) (Math.pow(2, rows) - 1);
            List<String> row = new ArrayList<>();
            for (int i = 0; i < cols; i++) row.add("");
            for (int i = 0; i < rows; i++) {
                ret.add(new ArrayList<>(row));
            }
            solve(root, ret , 0 ,  0 ,  cols - 1);
            return  ret;
        }

        void solve(TreeNode node, List<List<String>> ret, int row, int i, int j) {
            if (row == ret.size() || node == null) return;
            int mid = (i + j) / 2;
            ret.get(row).set(mid, Integer.toString(node.val));
            solve(node.left, ret, row + 1, i, mid - 1);
            solve(node.right, ret, row + 1, mid + 1, j);
        }

        int getHeight(TreeNode node) {
            if (node == null) return 0;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
}
