package LC.SOL;

import LC.DS.TreeNode;

public class BinaryTreeCameras {
    class Solution {
        int ret;

        public int minCameraCover(TreeNode root) {
            ret = 0;
            int tmp = dfs(root);
            return tmp == 0 ? 1 + ret : ret;
        }

        int dfs(TreeNode node) {
            if (node == null) return 2;
            int left = dfs(node.left), right = dfs(node.right);
            if (left == 0 || right == 0) {
                ret++;
                return 1;
            }
            return left == 1 || right == 1 ? 2 : 0;
        }
    }
}
