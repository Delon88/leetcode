package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            Trie trie = new Trie();
            for ( int i = 0 ; i < words.length ; i++) {
                trie.insert(words[i], i);
            }
            List<List<Integer>> ret= new ArrayList<>();
            for ( int i =0 ;i < words.length ;i ++) {
                trie.search(words, i , ret);
            }
            return ret;
        }

        boolean isPal(String w , int start, int end) {
            while ( start < end) {
                if ( w.charAt(start++) != w.charAt(end--)) return false;
            }
            return true;
        }


        class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word, int index) {
                TrieNode node = root;
                for ( int i = word.length() - 1; i >= 0 ; i--) {
                    char c = word.charAt(i);
                    if ( node.ch[c - 'a'] == null ) {
                        node.ch[c - 'a'] = new TrieNode();
                    }
                    if ( isPal(word, 0 , i)) node.pIndex.add(index);
                    node = node.ch[c - 'a'];
                }
                node.pIndex.add(index);
                node.wIndex = index;
            }

            public void search( String[] words , int index, List<List<Integer>> ret) {
                TrieNode node = root;
                for ( int i = 0 ;i < words[index].length() ; i++) {
                    char c = words[index].charAt(i);
                    if ( node.wIndex != -1 && node.wIndex != index && isPal(words[index] , i , words[index].length() - 1)) {
                        ret.add(Arrays.asList(index, node.wIndex ));
                    }
                    node = node.ch[ c- 'a'];
                    if ( node == null ) return;
                }

                for ( int i : node.pIndex) {
                    if ( i != index ) {
                        ret.add(Arrays.asList(index, i));
                    }
                }
            }
        }

        class TrieNode {
            public TrieNode[] ch = new TrieNode[26];
            public int wIndex = -1;
            public List<Integer> pIndex = new ArrayList<>();

            public TrieNode() {

            }
        }

    }
}
