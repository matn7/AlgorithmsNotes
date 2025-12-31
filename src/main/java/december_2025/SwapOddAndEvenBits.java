package december_2025;

public class SwapOddAndEvenBits {

    // O(1) time | O(1) space
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }
        return res;
    }

}
