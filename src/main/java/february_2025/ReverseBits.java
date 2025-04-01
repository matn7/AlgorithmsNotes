package february_2025;

public class ReverseBits {

    public int reverseBits(int n) {
        int res = n;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }
        return res;
    }

}
