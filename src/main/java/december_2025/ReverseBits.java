package december_2025;

public class ReverseBits {

    public static void main(String[] args) {
        int n = 43261596;

        ReverseBits reverseBits = new ReverseBits();
        int result = reverseBits.reverseBits(n);
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
