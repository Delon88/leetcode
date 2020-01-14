package LC.SOL;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IteratorforCombination {
    class Solution {


        class CombinationIterator {
            PriorityQueue<String> pq = new PriorityQueue<>();

            public CombinationIterator(String characters, int combinationLength) {
                generate(characters.toCharArray(), combinationLength, 0, new StringBuilder());
            }

            void generate(char[] chs, int n, int level, StringBuilder b) {
                if (b.length() == n) {
                    pq.offer(b.toString());
                    return;
                }
                for (int i = level; i < chs.length; i++) {
                    b.append(chs[i]);
                    generate(chs, n, i + 1, b);
                    b.deleteCharAt(b.length() - 1);
                }
            }


            public String next() {
                return pq.poll();
            }

            public boolean hasNext() {
                return !pq.isEmpty();
            }
        }
    }

    class Solution1 {
        // abcd
        // 0123
        // ab=01
        // ac=02
        class CombinationIterator {

            Map<Character, Integer> ch2i;
            String chs;
            StringBuilder re;
            int combLen;

            public CombinationIterator(String characters, int combinationLength) {
                ch2i = new HashMap<>();
                re = new StringBuilder();
                chs = characters;
                combLen = combinationLength;
                for (int i = 0; i < combLen; i++) {
                    re.append(chs.charAt(i));
                }
                for (int i = 0; i < chs.length(); i++) {
                    ch2i.put(chs.charAt(i), i);
                }
            }

            public String next() {
                String ret = re.toString();
                int i = chs.length() -1;
                while ( re.length() > 0 && ch2i.get(re.charAt(re.length() - 1)) == i) {
                    re.deleteCharAt(re.length() -1 );
                    i--;
                }
                if ( re.length() == 0 ) {
                    re = null; return ret;
                }
                i = ch2i.get(re.charAt(re.length() - 1));
                re.deleteCharAt(re.length() - 1);
                while (re.length() < combLen) {
                    re.append(chs.charAt(++i));
                }
                return ret;
            }

            public boolean hasNext() {
                return re != null;
            }
        }
    }
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
