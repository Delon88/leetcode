package LC.SOL;

public class FindPermutation {
    public class Solution {
        public int[] findPermutation(String s) {
            int n = s.length() + 1;
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = i + 1;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'D') {
                    int start = i;
                    while (i < s.length() && s.charAt(i) == 'D') i++;
                    reverse(ret, start, i);
                }
            }
            return ret;
        }


        void reverse(int[] a, int start, int end) {
            while (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
