package LC.SOL;

public class AddandSearchWordDatastructuredesign {
    class WordDictionary {

        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root= new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for ( int i = 0 ;i < word.length() ;i++) {
                char c= word.charAt(i);
                if ( node.ch[c - 'a'] == null) {
                    node.ch[c - 'a'] = new TrieNode();
                }
                node = node.ch[ c - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return dfs(word, 0 , root);
        }

        public boolean dfs(String word, int start, TrieNode node) {
            if ( start == word.length() ) return node.isWord;
            char c = word.charAt(start);
            if ( c == '.') {
                for ( TrieNode child : node.ch) {
                    if ( child != null && dfs(word, start + 1, child) ) return true;
                }
            } else {
                if ( node.ch[c - 'a'] == null) return false;
                else return dfs(word, start + 1 , node.ch[c - 'a']);
            }
            return false;
        }


        class TrieNode {
            TrieNode[] ch = new TrieNode[26];
            boolean isWord;
            public TrieNode() {
            }
        }
    }
}
