package LC.SOL;

public class StreamofCharacters {
    class StreamChecker {

        class TrieNode {
            boolean isWord;
            TrieNode[] ch = new TrieNode[26];
        }

        TrieNode root = new TrieNode();
        StringBuilder b = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String w : words) {
                TrieNode node = root;
                for (int i = w.length() - 1; i >= 0; i--) {
                    char c = w.charAt(i);
                    if (node.ch[c - 'a'] == null) node.ch[c - 'a'] = new TrieNode();
                    node = node.ch[c - 'a'];
                }
                node.isWord = true;
            }
        }

        public boolean query(char letter) {
            b.append(letter);
            TrieNode node = root;
            for (int i = b.length() - 1; i >= 0 && node != null; i--) {
                char c = b.charAt(i);
                node = node.ch[c - 'a'];
                if ( node != null && node.isWord ) return true;
            }
            return false;
        }
    }
}
