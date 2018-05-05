package LC.SOL;

public class ReadNCharactersGivenRead4IICallmultipletimes {

    int read4(char[] buf) {
        return 0;
    }

    char[] tmp = new char[4];
    int bufferPtr  = 0 , bufferCount = 0;
    public int read(char[] buf, int n) {
        int total = 0;
        while ( total < n ) {
            if ( bufferPtr == 0 ) {
                bufferCount = read4(tmp);
            }
            if ( bufferCount == 0 ) break;
            while ( total < n && bufferPtr < bufferCount) {
                buf[total++] = tmp[bufferPtr++];
            }
            if ( bufferPtr == bufferCount) bufferPtr = 0;
        }
        return total;
    }
}
