package LC.SOL;

import java.util.Arrays;

/**
 * Created by nanhong on 11/27/2016.
 */
public class SuperPow {

    private final static int base = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1;
        int lastDigit = b[b.length - 1];
        int[] copyArr = Arrays.copyOf(b, b.length - 1);
        return powmod(superPow(a, copyArr), 10) * powmod(a, lastDigit) % base;
    }

    public int powmod(int a, int k) {
        a %= base;
        int ret = 1;
        for (int i = 0; i < k; i++) {
            ret = (ret * a) % base;
        }
        return ret;
    }
}
