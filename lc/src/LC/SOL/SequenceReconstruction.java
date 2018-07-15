package LC.SOL;

import java.util.*;

public class SequenceReconstruction {
    public class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            Map<Integer,Set<Integer>> graph = new HashMap<>();
            Map<Integer,Integer> indegree = new HashMap<>();
            for ( List<Integer> seq : seqs) {
                if ( seq.size() == 1 ) {
                    graph.putIfAbsent(seq.get(0), new HashSet<>());
                    indegree.putIfAbsent(seq.get(0), 0);
                } else {
                    for ( int i = 0 ; i < seq.size() - 1; i++) {
                        graph.putIfAbsent(seq.get(i), new HashSet<>());
                        indegree.putIfAbsent(seq.get(i), 0);

                        graph.putIfAbsent(seq.get(i + 1) , new HashSet<>());
                        indegree.putIfAbsent(seq.get(i + 1) , 0);

                        if ( graph.get(seq.get(i)).add(seq.get(i + 1))) {
                            indegree.put(seq.get(i + 1), indegree.getOrDefault(seq.get(i + 1), 0) + 1);
                        }
                    }
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for ( Map.Entry<Integer,Integer> d : indegree.entrySet()) {
                if ( d.getValue() == 0 ) q.offer(d.getKey());
            }

            int index = 0;
            while ( !q.isEmpty()) {
                if ( q.size() > 1 ) {
                    return false;
                }
                int node = q.poll();
                if ( index == org.length || org[index++] != node ) return false;
                for ( Integer nei: graph.get(node)) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if ( indegree.get(nei) == 0) q.offer(nei);
                }
            }
            return index == org.length && index == graph.size();
        }

    }
}
