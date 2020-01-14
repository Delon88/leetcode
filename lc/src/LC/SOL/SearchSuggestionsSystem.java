package LC.SOL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem {
    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> ret = new ArrayList<>();
            TreeMap<String,Integer> map = new TreeMap<>();
            Arrays.sort(products);
            List<String> productsList = Arrays.asList(products);
            for ( int i = 0 ; i < products.length; i++) map.put(products[i], i);
            String pre = "";
            for ( char c : searchWord.toCharArray()) {
                pre += c;
                String ceil = map.ceilingKey(pre);
                String floor = map.floorKey(pre + "~");
                if ( ceil == null || floor == null ) break;
                ret.add(productsList.subList(map.get(ceil), Math.min(map.get(ceil) + 3, map.get(floor) + 1)));
            }
            while ( ret.size() < searchWord.length()) ret.add(new ArrayList<>());
            return ret;
        }
    }
}
