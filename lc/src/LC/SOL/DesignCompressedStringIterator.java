package LC.SOL;

import java.util.Scanner;

public class DesignCompressedStringIterator {
    class StringIterator {
        int i;

        char[] A;

        int count;

        char curChar;

        public StringIterator(String compressedString) {
            i = 0;
            A = compressedString.toCharArray();
            count = 0;
        }

        public char next() {
            if (count > 0) {
                count--;
                return curChar;
            } else {
                if (hasNext()) {
                    curChar = A[i];
                    i++;
                    int sum = 0;
                    while (i < A.length && Character.isDigit(A[i])) {
                        sum = sum * 10 + (A[i] - '0');
                        i++;
                    }
                    count = sum;
                    count--;
                    return curChar;
                } else {
                    return ' ';
                }
            }
        }

        public boolean hasNext() {
            return i < A.length || count > 0;
        }
    }
}
