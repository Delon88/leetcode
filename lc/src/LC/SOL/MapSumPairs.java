package LC.SOL;

public class MapSumPairs {
    class MapSum {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
            node.value = val;
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return 0;
                }
                node = node.children[c - 'a'];
            }

            return solve(node);
        }

        private int solve(TrieNode node) {
            int sum = node.value;
            for (TrieNode c : node.children) {
                if (c != null) {
                    sum += solve(c);
                }
            }
            return sum;
        }

        class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public int value;
            public boolean isWord;

            public TrieNode() {
            }
        }
    }


}
