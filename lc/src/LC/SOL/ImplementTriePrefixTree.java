package LC.SOL;

public class ImplementTriePrefixTree {
    class Trie {

        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for ( int i = 0 ; i < word.length(); i++) {
                char c = word.charAt(i);
                if ( node.ch[c - 'a'] == null) {
                    node.ch[c - 'a'] = new TrieNode(c);
                }
                node = node.ch[c - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for ( int i = 0; i < word.length() ; i++) {
                char c = word.charAt(i);
                if ( node.ch[c - 'a'] == null) return false;
                node = node.ch[c - 'a'];
            }
            return node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for ( int i = 0; i < prefix.length() ; i++) {
                char c = prefix.charAt(i);
                if ( node.ch[c - 'a'] == null) return false;
                node = node.ch[c - 'a'];
            }
            return true;
        }

        class TrieNode {
            public TrieNode[] ch = new TrieNode[26];
            public char c;
            public boolean isWord  = false;
            public TrieNode(char c) {
                this.c = c;
            }
            public TrieNode() {}
        }
    }
}
