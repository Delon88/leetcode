package LC.SOL;

import java.util.*;

public class DesignSearchAutocompleteSystem {
    class AutocompleteSystem {

        class TrieNode {
            Map<Character, TrieNode> children;
            Map<String, Integer> counts;

            public TrieNode() {
                children = new HashMap<>();
                counts = new HashMap<>();
            }
        }

        TrieNode root;
        String prefix;


        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                insert(sentences[i], times[i]);
            }
        }

        private void insert(String s, int count) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                TrieNode node = curr.children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    curr.children.put(c, node);
                }
                curr = node;
                curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                insert(prefix, 1);
                prefix = "";
                return new ArrayList<>();
            }

            prefix = prefix + c;
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()));
            for (Map.Entry<String, Integer> s : curr.counts.entrySet()) {
                pq.offer(s);
                if ( pq.size() > 3 ) pq.poll();
            }

            List<String> res = new LinkedList<>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(0, pq.poll().getKey());
            }
            return res;
        }
    }

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
}
