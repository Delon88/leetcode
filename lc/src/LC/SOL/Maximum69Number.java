package LC.SOL;

public class Maximum69Number {
    class Solution {
        public int maximum69Number(int num) {
            char[] str = Integer.toString(num).toCharArray();
            int i = 0;
            while (i < str.length && str[i] != '6') {
                i++;
            }
            if ( i == str.length) return num;
            else {
                str[i] = '9'; return Integer.parseInt(new String(str));
            }
        }
    }
}
