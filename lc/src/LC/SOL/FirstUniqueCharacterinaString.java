package LC.SOL;

/**
 * Created by nanhong on 12/12/2016.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if ( c[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
