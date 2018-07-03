package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {

    class Solution {
        public List<List<String>> wordSquares(String[] words) {
            Trie trie = new Trie();
            for ( String w : words ) {
                trie.insert(w);
            }
            List<String> tmp = new ArrayList<>();
            List<List<String>> ret = new ArrayList<>();
            int len = words[0].length();
            for ( String w : words) {
                tmp.add(w);
                dfs( tmp, trie, ret, len);
                tmp.remove(tmp.size() - 1);
            }
            return ret;
        }

        void dfs(List<String> tmp, Trie trie, List<List<String>> ret, int len) {
            if ( len == tmp.size()) {
                ret.add(new ArrayList<>(tmp));
                return;
            }
            int index = tmp.size();
            StringBuilder b = new StringBuilder();
            for ( String t : tmp ) {
                b.append(t.charAt(index));
            }
            List<String> nextWords = trie.startWith(b.toString());
            for ( String nextW : nextWords) {
                tmp.add(nextW);
                dfs(tmp, trie, ret, len);
                tmp.remove(tmp.size() - 1);
            }
        }


        class Trie {
            TrieNode root;
            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                for ( int i = 0 ; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if ( node.ch[ c- 'a'] == null ) {
                        node.ch[c - 'a'] =  new TrieNode();
                    }
                    node = node.ch[ c - 'a'];
                    node.words.add(word);
                }
            }

            public List<String> startWith(String prefix) {
                TrieNode node = root;
                for ( int i = 0 ; i < prefix.length() ; i++) {
                    char c = prefix.charAt(i);
                    if ( node.ch[  c- 'a'] == null ) return new ArrayList<>();
                    node = node.ch[ c - 'a'];
                }
                return node.words;
            }
        }

        class TrieNode {
            TrieNode[] ch;
            List<String> words ;
            public TrieNode() {
                ch = new TrieNode[26];
                words = new ArrayList<>();
            }
        }
    }
}
