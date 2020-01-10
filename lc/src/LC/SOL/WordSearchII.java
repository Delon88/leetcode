package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    class Solution {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Trie trie;

        public List<String> findWords(char[][] board, String[] words) {
            trie = new Trie();
            for (String w : words) {
                trie.insert(w);
            }
            int m = board.length, n = board[0].length;
            Set<String> ret = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, trie.root, ret);
                }
            }
            return new ArrayList<>(ret);
        }

        void dfs(char[][] board, int x, int y, TrieNode node, Set<String> set) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
            char c = board[x][y];
            if (c == '#' || node.ch[c - 'a'] == null) return;
            node = node.ch[c - 'a'];
            if (node.word != null) {
                set.add(node.word);
            }
            board[x][y] = '#';
            for (int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                dfs(board, nextX, nextY, node, set);
            }
            board[x][y] = c;
        }

        class TrieNode {
            public TrieNode[] ch = new TrieNode[26];
            public String word;

            public TrieNode() {
            }
        }

        class Trie {

            public TrieNode root;

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
                node.word = word;
            }
        }
    }
}
