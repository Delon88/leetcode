package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    class Solution {

        public int expressiveWords(String S, String[] words) {
            List<Node> sL = getNodeList(S);

            int count = 0;
            for ( String w : words) {
                List<Node> wL = getNodeList(w);
                if ( wL.size() != sL.size()) continue;
                if ( compare(sL, wL)) count++;
            }
            return count;
        }

        boolean compare(List<Node> s, List<Node> w) {
            for ( int i = 0 ; i < s.size() ; i++) {
                Node sNode = s.get(i);
                Node wNode = w.get(i);
                if ( sNode.c != wNode.c) return false;
                if ( sNode.freq < wNode.freq) return false;
                if ( sNode.freq < 3 && wNode.freq != sNode.freq) return false;
            }
            return true;
        }

        List<Node> getNodeList(String S) {
            List<Node> sl = new ArrayList<>();
            for (int i = 0; i < S.length(); ) {
                char c = S.charAt(i);
                int j = i;
                while ( i < S.length() && S.charAt(i) == c) {
                    i++;
                }
                sl.add(new Node(c , i - j));
            }
            return sl;
        }

        class Node {
            char c;
            int freq;

            public Node(char c, int freq) {
                this.c = c;
                this.freq = freq;
            }
        }
    }
}
