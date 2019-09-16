package LC.SOL;

public class ConverttoBase_2 {
    class Solution {
        public String baseNeg2(int N) {
            String b = Integer.toBinaryString(N);
            StringBuilder bu = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                int index = b.length() - i - 1;
                if ( b.charAt(index) == '1')
            }
        }
    }
}
