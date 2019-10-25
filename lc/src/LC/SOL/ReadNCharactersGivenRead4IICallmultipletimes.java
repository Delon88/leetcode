package LC.SOL;

public class ReadNCharactersGivenRead4IICallmultipletimes {

    int read4(char[] buf) {
        return 0;
    }

    int offset = 0, count = 0;
    char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int total = 0;
        while ( total < n ) {
            if ( offset == 0 ) count = read4(tmp);
            if ( count == 0) break;
            while ( offset < count && total < n) {
                buf[total++] = tmp[offset++];
            }
            if ( offset == count ) offset = 0;
        }
        return total;
    }
}
