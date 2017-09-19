package LC.SOL;

import java.util.Scanner;

public class FractionAdditionandSubtraction {
    class Solution {
        public String fractionAddition(String expression) {
            Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
            int A = 0, B = 1;
            while (sc.hasNext()) {
                int a = sc.nextInt(), b = sc.nextInt();
                A = A * b + B * a;
                B = B * b;
                int gcd = gcd(Math.abs(A), Math.abs(B));
                A /= gcd;
                B /= gcd;
            }
            return A + "/" + B;
        }

        int gcd(int p, int q) {
            while (q != 0) {
                int tmp = q;
                q = p % q;
                p = tmp;
            }
            return p;
        }
    }
}
