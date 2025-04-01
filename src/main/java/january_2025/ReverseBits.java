package january_2025;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int result = reverseBits.reverseBits(5);
        System.out.println(result);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res += (bit << (31 - i));
        }
        return res;
    }

}
