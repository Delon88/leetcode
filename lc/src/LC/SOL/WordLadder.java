package LC.SOL;

import java.util.*;

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if ( beginWord.equals(endWord) || beginWord.length() != endWord.length()) return 0;
            Set<String> dict = new HashSet<>(wordList);
            if ( !dict.contains(endWord)) return 0;
            Set<String> v = new HashSet<>();
            v.add(beginWord);
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            int level = 1;
            while ( !q.isEmpty()) {
                level++;
                int size = q.size();
                for ( int k = 0 ; k < size ; k++) {
                    String parent = q.poll();
                    char[] pWord = parent.toCharArray();
                    for ( int i = 0 ; i < pWord.length ; i++) {
                        for ( char j = 'a' ; j <= 'z'  ; j++) {
                            if ( j == pWord[i]) continue;
                            char tmp = pWord[i];
                            pWord[i] = j;
                            String child = new String(pWord);
                            if ( child.equals(endWord)) return level;
                            if ( dict.contains(child) && !v.contains(child)) {
                                v.add(child);
                                q.offer(child);
                            }
                            pWord[i] = tmp;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
