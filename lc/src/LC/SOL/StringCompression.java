package LC.SOL;

public class StringCompression {
    static class Solution {
        public int compress(char[] chars) {
            if (chars.length == 0) return 0;
            int i = 0, j = 0;

            while (i < chars.length) {
                char c = chars[i];
                int count = 0;
                while (i < chars.length && c == chars[i]) {
                    i++;
                    count++;
                }
                chars[j] = c;
                j++;
                if (count > 1) {
                    int div = 1;
                    while (div <= count / 10) {
                        div *= 10;
                    }
                    while (div > 0) {
                        chars[j++] = (char) (count / div + '0');
                        count = count % div;
                        div /= 10;
                    }
                }
            }
            return j;
        }
    }

    public static void main(String[] args) {
        char[] c = {'a'};
        System.out.println(new Solution().compress(c));
    }
}
