
import LC.DS.TreeNode;

import java.util.*;

public class Test {
    class Solution {
        class Pair {
            TreeNode node; int vIndex;
            public Pair(TreeNode node, int vIndex) {
                this.node = node; this.vIndex = vIndex;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if ( root == null ) return ret;
            Map<Integer,List<Integer>> map = new HashMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));
            int min = 0 , max = 0;
            while ( !q.isEmpty()) {
                Pair p = q.poll();
                if ( !map.containsKey(p.vIndex)) { map.put(p.vIndex, new ArrayList<>());}
                map.get(p.vIndex).add(p.node.val);
                if ( p.node.left != null ) {
                    q.offer(new Pair(p.node.left , p.vIndex - 1));
                    min = Math.min(min, p.vIndex - 1);
                }
                if ( p.node.right != null ) {
                    q.offer(new Pair(p.node.right, p.vIndex + 1));
                    max = Math.max(max , p.vIndex + 1);
                }
            }
            for ( int i = min ;  i <= max ; i++) {
                ret.add(map.get(i));
            }
            return ret;
        }
    }
}
