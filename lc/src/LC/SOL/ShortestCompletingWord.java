package LC.SOL;

import java.util.Arrays;

public class ShortestCompletingWord {
    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] hash = new int[26];
            int count = 0;
            for (int i = 0; i < licensePlate.length(); i++) {
                if (Character.isLetter(licensePlate.charAt(i))) {
                    hash[Character.toLowerCase(licensePlate.charAt(i)) - 'a']++;
                    count++;
                }
            }
            int minLen = Integer.MAX_VALUE;
            String ret = "";
            for (String w : words) {
                int[] clone = Arrays.copyOf(hash, hash.length);
                if (contains(clone, w, count) && w.length() < minLen) {
                    minLen = w.length();
                    ret = w;
                }
            }
            return ret;
        }

        boolean contains(int[] hash, String w, int count) {
            for (int i = 0; i < w.length(); i++) {
                char c = Character.toLowerCase(w.charAt(i));
                if (hash[c - 'a'] > 0) {
                    hash[c - 'a']--;
                    count--;
                }
                if (count == 0) return true;
            }
            return false;
        }
    }
}
