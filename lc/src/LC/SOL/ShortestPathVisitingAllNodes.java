package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {
    class Solution {
        public int shortestPathLength(int[][] graph) {
            Queue<Node> q = new LinkedList<>();
            Set<Node> set = new HashSet<>();
            int n = graph.length;
            for ( int i = 0 ; i < graph.length ; i++) {
                set.add(new Node(i , 1 << i , 0));
                q.offer(new Node(i, 1 << i, 0));
            }
            int allVisited = ( 1 << n ) - 1;
            while ( !q.isEmpty()) {
                Node node = q.poll();
                if ( node.visited == allVisited) {
                    return node.cost ;
                } else {
                    int[] neis = graph[node.label];
                    for ( int nei : neis) {
                        Node next = new Node(nei, node.visited | (1 << nei) , node.cost + 1);
                        if ( set.add(next)) {
                            q.offer(next);
                        }
                    }
                }
            }
            return -1;
        }

        class Node {
            public int label;
            public int visited;
            public int cost;
            public Node(int label,int visited, int cost) {
                this.label = label;
                this.visited = visited;
                this.cost = cost;
            }

            @Override
            public boolean equals(Object obj) {
                if ( obj instanceof Node ) {
                    Node node = (Node) obj;
                    return node.label == this.label && this.visited == visited;
                } else {
                    return false;
                }
            }

            @Override
            public int hashCode(){
                return 13 * visited + 1337 * label;
            }
        }
    }


}
