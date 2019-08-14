package LC.SOL;

public class LongPressedName {
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0 , j = 0;
            while ( i < name.length() && j < typed.length()) {
                char c = name.charAt(i);
                int nCount = 0;
                while ( i < name.length() && name.charAt(i) == c) {
                    i++;nCount++;
                }
                int tCount = 0;
                while ( j < typed.length() && typed.charAt(j) == c) {
                    j++;tCount++;
                }
                if ( tCount < nCount ) return false;
            }
            return i == name.length() && j == typed.length();
        }
    }
}
