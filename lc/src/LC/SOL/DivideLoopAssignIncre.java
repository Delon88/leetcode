package LC.SOL;

public class DivideLoopAssignIncre {


    static int divide(int x, int y) {

        for ( int i = 0 ; i < x ; i++) {

        }
        return 0;
    }

    static int sub(int x, int y) {
        for ( int i = 0 ; i < y ; i++) {
            x = decre(x);
        }
        return x;
    }

    static int decre(int x) {
        int y = 0;
        int z = 0;
        for ( int i = 0 ; i < x; i++) {
            y = z;
            z = incre(y);
        }
        return y;
    }

    static int incre(int x) {
        return x + 1;
    }

    public static void main(String[] args) {

    }
}
