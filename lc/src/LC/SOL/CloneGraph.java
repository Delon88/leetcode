package LC.SOL;

import LC.DS.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if ( node == null ) return null;
            Map<Integer,UndirectedGraphNode> map = new HashMap<>();
            return clone(node, map);
        }

        UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> map) {
            if ( map.containsKey(node.label)) return map.get(node.label);
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node.label, newNode);
            for ( UndirectedGraphNode nei : node.neighbors) {
                newNode.neighbors.add(clone(nei, map));
            }
            return newNode;
        }
    }
}
