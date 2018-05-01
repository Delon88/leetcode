package LC.SOL;

import java.util.*;

public class WordLadderII {
    static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ret = new ArrayList<>();
            if ( beginWord.equals(endWord) || beginWord.length() != endWord.length() ) return ret;
            Set<String> dict = new HashSet<>(wordList);
            if ( !dict.contains(endWord)) return ret;
            Map<String,Set<String>> backTrack = new HashMap<>();
            Map<String,Integer> ladder = new HashMap<>();
            backTrack.put(beginWord, null);
            int level = 0 ;
            ladder.put(beginWord, level);
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            boolean found = false;
            while ( !q.isEmpty() && !found) {
                int size = q.size();
                level++;
                for ( int k = 0 ; k < size ; k++) {
                    String parent = q.poll();
                    char[] pWord = parent.toCharArray();
                    for ( int i = 0 ; i < pWord.length ;i++) {
                        for ( char j = 'a' ;  j <= 'z' ; j++) {
                            if ( j == pWord[i]) continue;
                            char tmp = pWord[i];
                            pWord[i] = j;
                            String child = new String(pWord);
                            if ( child.equals(endWord)) {
                                found = true;
                                put(backTrack, parent, child);
                            }
                            if ( dict.contains(child)) {
                                if ( !ladder.containsKey(child)) {
                                    put(backTrack, parent, child);
                                    ladder.put(child, level);
                                    q.offer(child);
                                } else if ( ladder.get(child) > ladder.get(parent)) {
                                    put(backTrack, parent, child);
                                }
                            }
                            pWord[i] = tmp;
                        }
                    }
                }
            }

            if ( found) {
                build(backTrack, new ArrayList<>(), ret, endWord);
            }
            return ret;
        }

        void put(Map<String, Set<String>> backTrack, String parent, String child) {
            if (!backTrack.containsKey(child)) {
                backTrack.put(child, new HashSet<>());
            }
            backTrack.get(child).add(parent);
        }

        void build(Map<String,Set<String>> backTrack, List<String> path, List<List<String>> ret, String end) {
            path.add(end);
            if ( backTrack.get(end) == null) {
                List<String> tmp = new ArrayList<>(path);
                Collections.reverse(tmp);
                ret.add(tmp);
            } else {
                for ( String parent: backTrack.get(end)) {
                    build(backTrack, path, ret, parent);
                }
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        String hot = "hot";
        String dog = "dog";
        List<String> list = Arrays.asList("hot", "dog", "dot");
        System.out.println(new Solution().findLadders(hot, dog, list));
    }
}
