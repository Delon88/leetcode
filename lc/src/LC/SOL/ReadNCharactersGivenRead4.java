package LC.SOL;

public class ReadNCharactersGivenRead4 {

    int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean EOF = false;
        char[] tmp = new char[4];
        while ( readBytes < n && !EOF) {
            int count = read4(tmp);
            if ( count < 4) {
                EOF = true;
            }
            int read = Math.min( count, n - readBytes);
            for ( int i = 0 ;i < read ; i++) {
                buf[readBytes] = tmp[i];
                readBytes++;
            }
        }
        return readBytes;
    }

}
