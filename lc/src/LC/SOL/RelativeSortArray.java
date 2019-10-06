package LC.SOL;

import java.util.*;

public class RelativeSortArray {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : arr1) map.put(i, map.getOrDefault(i, 0) + 1);
            int k = 0;
            for (int j = 0; j < arr2.length; j++) {
                for ( int i = 0 ; i < map.get(arr2[j]) ; i++) {
                    arr1[k++] = arr2[j];
                }
                map.remove(arr2[j]);
            }
            for ( Map.Entry<Integer,Integer> e : map.entrySet()) {
                for ( int i =0; i < e.getValue() ; i++) arr1[k++] = e.getKey();
            }
            return arr1;
        }
    }
}
