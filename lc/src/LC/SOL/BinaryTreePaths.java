package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ret= new ArrayList<>();
            dfs(root, new ArrayList<>(), ret);
            return ret;
        }

        void dfs(TreeNode root, List<String> tmp, List<String> ret) {
            if (root == null) return;
            tmp.add(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                ret.add(String.join("->", tmp));
            }
            if ( root.left != null ) dfs(root.left, tmp, ret);
            if ( root.right != null ) dfs(root.right , tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
