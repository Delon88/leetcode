package LC.SOL;

public class ImplementTriePrefixTree {
    class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.ch[c - 'a'] == null) {
                    node.ch[c - 'a'] = new TrieNode();
                }
                node = node.ch[c - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.ch[c - 'a'] == null) return false;
                node = node.ch[c - 'a'];
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.ch[c - 'a'] == null) return false;
                node = node.ch[c - 'a'];
            }
            return true;
        }

        public void delete(String key) {
            deleteHelper(key, 0 , root);
        }


        public boolean deleteHelper(String key, int i, TrieNode cur) {
            if ( i == key.length()) {
                if ( !cur.isWord) {
                    return false;
                }
                cur.isWord = false;
                return hasNoChildren(cur);
            }
            char c = key.charAt(i);
            TrieNode ch = cur.ch[ c - 'a'];
            if ( ch == null ) {
                return false;
            }
            boolean shouldDelete = deleteHelper(key, i + 1, ch);
            if ( shouldDelete ) {
                cur.ch[c-'a'] = null;
                return hasNoChildren(cur);
            }
            return false;
        }

        boolean hasNoChildren(TrieNode node) {
            for ( int i = 0 ; i < 26 ; i++) {
                if ( node.ch[i] != null ) {
                    return false;
                }
            }
            return true;
        }

        class TrieNode {
            public TrieNode[] ch = new TrieNode[26];
            public boolean isWord = false;
        }
    }

    public static void main(String[] args) {

    }
}
