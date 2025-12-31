package december_2025;

public class ReadNChars extends Reader {

    // O(n) time | O(1) space
    private char[] buf4 = new char[4];
    private int bufPtr = 0;
    private int bufCnt = 0;

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

class Reader {
    public int read4(char[] buf4) {
        return 0;
    }
}
