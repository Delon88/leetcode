package LC.SOL;

import java.util.*;

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord.equals(endWord) || beginWord.length() != endWord.length()) return 0;
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord)) return 0;
            Set<String> v = new HashSet<>(); v.add(beginWord);
            Queue<String> q = new LinkedList<>(); q.offer(beginWord);
            int level = 1;
            while (!q.isEmpty()) {
                level++;
                for (int k = q.size(); k > 0; k--) {
                    char[] word = q.poll().toCharArray();
                    for (int i = 0; i < word.length; i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == word[i]) continue;
                            char tmp = word[i];
                            word[i] = c;
                            String child = new String(word);
                            if (child.equals(endWord)) return level;
                            if (dict.contains(child) && v.add(child)) {
                                q.offer(child);
                            }
                            word[i] = tmp;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
