package LC.SOL;

import java.util.*;

public class WordAbbreviation {
    static class Solution {
        //        Given an array of n distinct non-empty strings, you need to generate minimal possible
//        abbreviations for every word following rules below.
//
//        Begin with the first character and then the number of characters abbreviated, which followed by the last character.
//        If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used
//        instead of only the first character until making the map from word to abbreviation become unique.
//        In other words, a final abbreviation cannot map to more than one original words.
//        If the abbreviation doesn't make the word shorter, then keep it as original.
//        Example:
//        Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
//        Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
//        Note:
//        Both n and the length of each word will not exceed 400.
//        The length of each word is greater than 1.
//        The words consist of lowercase English letters only.
//        The return answers should be in the same order as the original array.
        public List<String> wordsAbbreviation(List<String> dict) {
            Map<String, List<Integer>> map = new HashMap<>();
            int[] prefix = new int[dict.size()];
            String[] arr = new String[dict.size()];
            for (int i = 0; i < dict.size(); i++) {
                prefix[i] = 1;
                String ab = getAbbr(dict.get(i), 1);
                arr[i] = ab;
                if (!map.containsKey(ab)) map.put(ab, new ArrayList<>());
                map.get(ab).add(i);
            }

            while (map.size() > 0) {
                boolean hasDup = false;
                Map<String,List<Integer>> next = new HashMap<>();
                for ( Map.Entry<String,List<Integer>> e : map.entrySet()) {
                    if ( e.getValue().size() > 1 ) {
                        for ( int i : e.getValue()) {
                            prefix[i]++;
                            if ( prefix[i] < dict.get(i).length() - 2) {
                                String ab = getAbbr(dict.get(i), prefix[i]);
                                arr[i] = ab;
                                if ( !next.containsKey(ab)) next.put(ab, new ArrayList<>());
                                next.get(ab).add(i);
                            } else {
                                arr[i] = dict.get(i);
                            }
                        }
                    }
                }
                map = next;
            }
            return Arrays.asList(arr);
        }

        String getAbbr(String word, int start) {
            if (start >= word.length() - 2) return word;
            return word.substring(0, start) + (word.length() - start - 1) + word.charAt(word.length() - 1);
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("interval");list.add("interval");list.add("like");
        System.out.println(new Solution().wordsAbbreviation(list));
    }
}
