package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> ret = new ArrayList<>();
            Trie trie = new Trie();
            for (String w : words) {
                trie.insert(w);
            }
            for (String w : words) {
                if (trie.dfs(w, w)) ret.add(w);
            }
            return ret;
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

            public boolean dfs(String word, String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (node.children[c - 'a'] == null) {
                        return false;
                    }
                    node = node.children[c - 'a'];
                    if (node.isWord && i != prefix.length() - 1 && dfs(word, prefix.substring(i + 1))) return true;
                }
                if (node.isWord && word.length() != prefix.length()) return true;
                else return false;
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
