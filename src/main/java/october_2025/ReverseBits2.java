package october_2025;

public class ReverseBits2 {

    public static void main(String[] args) {
        int n = 43261596;
        ReverseBits2 reverseBits2 = new ReverseBits2();
        int result = reverseBits2.reverseBits(n);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << 31 - i);
        }
        return res;
    }

}
