package LC.SOL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanhong on 1/29/2017.
 */
public class WordSquares {

    class Solution {
        public List<List<String>> wordSquares(String[] words) {
            Trie trie = new Trie();
            for (String w : words) {
                trie.insert(w);
            }
            List<List<String>> ret = new ArrayList<>();
            for ( String w : words) {
                List<String> sol = new ArrayList<>();
                sol.add(w);
                dfs(ret, sol, words[0].length(), trie);
            }
            return ret;
        }

        void dfs(List<List<String>> ret, List<String> sol, int len, Trie trie) {
            if (sol.size() == len) {
                ret.add(new ArrayList<>(sol));
                return;
            }

            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < sol.size(); i++) {
                prefix.append(sol.get(i).charAt(sol.size()));
            }
            List<String> words = trie.startWith(prefix.toString());
            for ( String w : words) {
                sol.add(w);
                dfs(ret, sol, len , trie);
                sol.remove(sol.size() - 1);
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

            public List<String> startWith(String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (node.children[c - 'a'] == null) return new ArrayList<>();
                    node = node.children[c - 'a'];
                }
                List<String> words = new ArrayList<>();
                dfs( node, new StringBuilder(prefix), words);
                return words;
            }

            public void dfs(TrieNode node, StringBuilder b, List<String> words) {
                if (node.isWord) {
                    words.add(b.toString());
                    return;
                }
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        b.append((char) (i + 'a'));
                        dfs(node.children[i], b, words);
                        b.deleteCharAt(b.length() - 1);

                    }
                }
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
