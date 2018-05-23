package LC.SOL;

public class MaximumProductofWordLengths {
    class Solution {
        public int maxProduct(String[] words) {
            int[] bitA = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                int bit = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    bit |= ( 1 << (words[i].charAt(j) - 'a'));
                }
                bitA[i] = bit;
            }
            int max = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((bitA[i] & bitA[j]) == 0) {
                        max = Math.max(words[i].length() * words[j].length(), max);
                    }
                }
            }
            return max;
        }
    }
}
