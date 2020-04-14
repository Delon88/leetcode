package LC.SOL;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    class Solution {
        public List<String> printVertically(String s) {
            String[] A = s.split(" ");
            int size = 0;
            for (int i = 0; i < A.length; i++) size = Math.max(A[i].length(), size);
            List<String> ret = new ArrayList<>(size);
            for ( int i = 0 ; i < size ; i++) {
                StringBuilder b = new StringBuilder();
                for ( int j = 0 ; j < A.length ; j++) {
                    b.append( i < A[j].length() ? A[j].charAt(i) : " ");
                }
                while ( b.length() > 0 && b.charAt(b.length() - 1) == ' ') b.deleteCharAt(b.length()-1);
                ret.add(b.toString());
            }
            return ret;
        }
    }
}
