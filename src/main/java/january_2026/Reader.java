package january_2026;

public class Reader extends Reader4 {
    private char[] buf4 = new char[4];
    private int bufPtr = 0;
    private int bufCnt = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int readChars = 0;
        while (readChars < n) {
            if (bufPtr == bufCnt) {
                bufCnt = read4(buf4);
                bufPtr = 0;
                if (bufCnt == 0) {
                    break;
                }
            }
            buf[readChars++] = buf4[bufPtr++];
        }
        return readChars;
    }
}

class Reader4 {
    int read4(char[] buf4) {
        return 4;
    }
}