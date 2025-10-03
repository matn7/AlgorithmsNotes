package september_2025;

public class BitwiseAnd {

    public static void main(String[] args) {
        int left = 5;
        int right = 7;

        BitwiseAnd bitwiseAnd = new BitwiseAnd();
        int result = bitwiseAnd.rangeBitwiseAnd(left, right);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            i++;
        }
        return left << i;
    }

    // O(1) time | O(1) space
    public int rangeBitwiseAnd2(int left, int right) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (left >> i) & 1;
            if (bit == 0) {
                continue;
            }

            int remain = left % (1 << (i + 1));
            int diff = (1 << (i + 1)) - remain;
            if (right - left < diff) {
                res = res | (1 << i);
            }
        }
        return res;
    }

}
