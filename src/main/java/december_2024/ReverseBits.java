package december_2024;

public class ReverseBits {

    public static void main(String[] args) {

        ReverseBits reverseBits = new ReverseBits();
        int result = reverseBits.reverseBits(43261596);
        System.out.println(result);

    }

    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }

    public int reverseBits2(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                builder.append(1);
            } else {
                builder.append(0);
            }
            n = n >> 1;
        }

        int sum = 0;
        int pow = 1;
        String string = builder.toString();
        for (int i = string.length() - 1; i >= 0; i--) {
            char c = string.charAt(i);
            if (c == '1') {
                sum += pow;
            }
            pow *= 2;
        }
        return sum;
    }

}
