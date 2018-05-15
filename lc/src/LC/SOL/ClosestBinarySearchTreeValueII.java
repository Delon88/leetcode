package LC.SOL;

import LC.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
    class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Stack<Integer> succ = new Stack<>();
            Stack<Integer> pre = new Stack<>();
            inOrder(root, target, pre,false);
            inOrder(root, target, succ, true);

            List<Integer> ret = new ArrayList<>();
            for ( int i =0 ; i < k ; i++) {
                if ( pre.isEmpty()) {
                    ret.add(succ.pop());
                } else if ( succ.isEmpty()) {
                    ret.add(pre.pop());
                } else if ( Math.abs(succ.peek() - target) < Math.abs(pre.peek() - target)) {
                    ret.add(succ.pop());
                } else {
                    ret.add(pre.pop());
                }
            }
            return ret;
        }

        void inOrder(TreeNode node, double target, Stack<Integer> stack, boolean reverse) {
            if (node == null) return;
            inOrder(reverse ? node.right : node.left, target, stack, reverse);
            if ((!reverse && node.val > target) || (reverse && node.val <= target)) return;
            stack.push(node.val);
            inOrder(reverse ? node.left: node.right, target, stack, reverse);
        }
    }
}
