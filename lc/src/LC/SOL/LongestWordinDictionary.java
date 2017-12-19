package LC.SOL;

public class LongestWordinDictionary {
    class Solution {

        int max = 0;
        String maxString = "";

        public String longestWord(String[] words) {
            Trie trie = new Trie();
            for (int i = 0; i < words.length; i++) {
                trie.insert(words[i]);
            }
            dfs(trie.root, new StringBuilder());
            return maxString;
        }

        void dfs(TrieNode node, StringBuilder b) {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && node.children[i].isWord) {
                    b.append((char) (i + 'a'));
                    if (b.length() > max) {
                        max = b.length();
                        maxString = b.toString();
                    }
                    dfs(node.children[i], b);
                    b.deleteCharAt(b.length() - 1);
                }
            }
        }

        class Trie {

            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.isWord = true;
            }

            public boolean startWith(String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (node.children[c - 'a'] == null) return false;
                    node = node.children[c - 'a'];
                }
                return true;
            }

            public boolean search(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.children[c - 'a'] == null) return false;
                    node = node.children[c - 'a'];
                }
                return node.isWord;
            }
        }

        class TrieNode {

            public TrieNode[] children = new TrieNode[26];
            public boolean isWord;

            public TrieNode() {

            }
        }
    }


}
