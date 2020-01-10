package LC.SOL;

import LC.DS.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {
    public class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return node;
            Map<Integer, Node> v = new HashMap<>();
            return clone(v , node);
        }

        Node clone(Map<Integer, Node> v, Node node) {
            if ( v.containsKey(node.val)) return v.get(node.val);
            Node clone = new Node(node.val, new ArrayList<>());
            v.put(node.val , clone);
            for ( Node nei : node.neighbors) {
                clone.neighbors.add(clone(v , nei));
            }
            return clone;
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
