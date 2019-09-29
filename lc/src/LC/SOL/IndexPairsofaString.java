package LC.SOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndexPairsofaString {

    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            List<int[]> l = new ArrayList<>();
            for (String w : words) {
                int i = -1;
                while ((i = text.indexOf(w, i + 1)) != -1) l.add(new int[]{i, i + w.length() - 1});
            }
            Collections.sort(l, (a, b) -> {if ( a[0] == b[0]) return a[1] - b[1]; else return a[0] - b[0];});
            int[][] ret = new int[l.size()][2];
            for (int i = 0; i < ret.length; i++) ret[i] = l.get(i);
            return ret;
        }
    }

    class Solution1 {
        public int[][] indexPairs(String text, String[] words) {
            Trie t = new Trie();
            for (String w : words) {
                t.insert(w);
            }
            List<int[]> l = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) {
                int j = i;
                TrieNode node = t.root;
                while (j < text.length() && node.ch[text.charAt(j) - 'a'] != null) {
                    node = node.ch[text.charAt(j) - 'a'];
                    if (node.isWord) l.add(new int[]{i, j});
                    j++;
                }
            }
            int[][] ret = new int[l.size()][2];
            for (int i = 0; i < ret.length; i++) ret[i] = l.get(i);
            return ret;
        }

        class TrieNode {
            TrieNode[] ch = new TrieNode[26];
            boolean isWord = false;
        }

        class Trie {
            TrieNode root = new TrieNode();

            public Trie() {
            }

            void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.ch[c - 'a'] == null) node.ch[c - 'a'] = new TrieNode();
                    node = node.ch[c - 'a'];
                }
                node.isWord = true;
            }
        }
    }
}
