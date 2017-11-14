package LC.SOL;

import LC.DS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class EqualTreePartition {
    class Solution {

        public boolean checkEqualTree(TreeNode root) {
            if ( root == null ) return false;
            Map<Integer,Integer> map = new HashMap<>();
            int sum = post(root, map);
            if ( sum == 0) return map.getOrDefault(sum /2, 0 ) > 1;
            if ( sum % 2 == 0 && map.containsKey(sum / 2)) return true;
            else return false;
        }

        int post(TreeNode node, Map<Integer,Integer> map) {
            if ( node == null ) return 0;
            int left = post(node.left, map);
            int right = post(node.right, map);
            int cur = left + right + node.val;
            map.put( cur, map.getOrDefault(cur, 0) + 1);
            return cur;
        }

    }
}
