package LC.WA;

public class Trie {


    TrieNode root;

    public Trie(String[] words) {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ( node.ch[ c- 'a'] == null ) {
                node.ch[c - 'a'] = new TrieNode();
            }
            node = node.ch[ c - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for ( int i = 0 ;  i < word.length(); i++) {
            char c = word.charAt(i);
            if ( node.ch[ c- 'a'] == null) return false;
            node = node.ch[c - 'a'];
        }
        return node.isWord;
    }



    class TrieNode {
        public TrieNode[] ch = new TrieNode[26];
        public boolean isWord;
    }
}
