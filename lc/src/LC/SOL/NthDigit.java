package LC.SOL;

public class NthDigit {
    public int findNthDigit(int n) {
        long count = 9;
        int len = 1;
        int start = 1;
        while ( n > count * len ) {
            n-= count* len;
            count *= 10;
            len++;
            start *= 10;
        }
        start += ( n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }
}
