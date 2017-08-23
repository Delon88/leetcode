package LC.SOL;

public class ComplexNumberMultiplication {
    class Solution {

        public String complexNumberMultiply(String a, String b) {
            int[] aR = parse(a);
            int[] bR = parse(b);
            int real = aR[0] * bR[0] - (aR[1] * bR[1]);
            int vir = aR[1] * bR[0] + bR[1] * aR[0];
            return Integer.toString(real) + "+" + Integer.toString(vir) + "i";
        }

        int[] parse(String s) {
            String[] arr = s.substring(0, s.length() - 1).split("\\+");
            return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
        }
    }
}
