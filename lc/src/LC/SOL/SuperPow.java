package LC.SOL;


public class SuperPow {

    int base = 1337;

    //  (a ^ 123) % m = (( a ^ 12 ) ^ 10 % m) * ( a ^ 3 ) % m
    public int superPow(int a, int[] b) {
        if ( b.length == 1 ) return powmod( a, b[0]);
        return powArray(a , b , b.length - 1);
    }

    public int powArray(int a, int[] b , int endIndex) {
        if ( endIndex < 0 ) return 1;
        return powmod(powArray(a , b, endIndex - 1) , 10) * powmod(a , b[endIndex]) % base;
    }

    public int powmod(int a, int k ) {
        a %= base;
        int ret = 1;
        for ( int i = 0 ; i < k ; i++) {
            ret = ( ret * a ) % base;
        }
        return ret;
    }
}
