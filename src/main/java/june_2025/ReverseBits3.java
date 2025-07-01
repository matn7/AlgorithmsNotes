package june_2025;

public class ReverseBits3 {

    // you need treat n as an unsigned value
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
