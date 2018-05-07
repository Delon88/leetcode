package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    class Solution {
        int[][] dirs = {{1, 0 } , {0,1}, {-1, 0}, {0 , -1}};
        Trie trie;
        public List<String> findWords(char[][] board, String[] words) {
            trie = new Trie();
            for ( String w : words) {
                trie.insert(w);
            }
            int m = board.length,n = board[0].length;
            Set<String> ret = new HashSet<>();
            boolean[][] v = new boolean[m][n];
            for ( int i = 0 ;i <  m ;i++) {
                for ( int j = 0 ; j <  n ;j++) {
                    dfs(board, "", v , i , j , ret);
                }
            }
            return new ArrayList<>(ret);
        }

        void dfs(char[][] board, String w, boolean[][] v, int x, int y, Set<String> ret) {
            if ( x < 0 || x >= board.length || y < 0 || y >= board[0].length || v[x][y]) return;
            w = w + board[x][y];
            if ( !trie.startsWith(w)) return;
            if ( trie.search(w)) ret.add(w);
            v[x][y] = true;
            for ( int[] d : dirs) {
                int nextX = x + d[0], nextY = y + d[1];
                dfs(board, w, v, nextX, nextY, ret);
            }
            v[x][y] = false;
        }

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
                        node.ch[c - 'a'] = new TrieNode();
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
                public boolean isWord  = false;
                public TrieNode() {}
            }
        }
    }
}
