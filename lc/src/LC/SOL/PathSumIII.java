package LC.SOL;

import LC.DS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    class Solution {
        public int pathSum(TreeNode root, int sum) {
            Map<Integer,Integer> prefixSum = new HashMap<>();
            prefixSum.put(0, 1);
            return sum(root, 0 , sum , prefixSum);
        }

        int sum(TreeNode node, int curSum, int target, Map<Integer,Integer> prefixSum  ) {
            if ( node == null ) return 0;
            curSum += node.val;
            int ret = prefixSum.getOrDefault(curSum - target, 0);
            prefixSum.put(curSum , prefixSum.getOrDefault(curSum, 0 ) + 1);
            ret += sum(node.left, curSum, target, prefixSum) + sum( node.right, curSum, target, prefixSum);
            prefixSum.put(curSum, prefixSum.get(curSum) - 1);
            return ret;
        }

    }
}
